/**
 * cb2java - Dynamic COBOL copybook parser for Java. Copyright (C) 2006 James
 * Watson
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 1, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 675 Mass
 * Ave, Cambridge, MA 02139, USA.
 */
package net.sf.cb2java.copybook;

import net.sf.cb2java.Values;
import net.sf.cb2java.types.Element;
import net.sf.cb2java.types.Group;
import net.sf.cb2java.types.SignedSeparate;
import net.sf.cb2xml.sablecc.analysis.DepthFirstAdapter;
import net.sf.cb2xml.sablecc.node.*;
import net.sf.cb2xml.sablecc.parser.Parser;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This class handles the hard part of the parsing work. It captures all the
 * parsing events of the sablecc parsing classes and marks up Item instances for
 * each field definition
 *
 * @author James Watson (adapted from Cb2XML project)
 */
class CopybookAnalyzer extends DepthFirstAdapter {

    Values values = new Values();
    private Parser parser;
    private Item document;
    private Item current;

    /**
     * Creates a new instance with the given parser and name
     *
     * @param copyBookName the name to give this copybook
     * @param parser sablecc parser instance
     */
    CopybookAnalyzer(String copyBookName, Parser parser) {
        document = new Item(values, true);
        document.name = copyBookName;
        current = document;
        this.parser = parser;
    }

    /**
     * getter for XML document
     */
    public Copybook getDocument() {
        return (Copybook) document.getElement();
    }

    /**
     * enter copybook, set up XML DOM and root element
     */
    @Override
    public void inARecordDescription(ARecordDescription node) {
        // TODO begin
    }

    /**
     * exit root element, save XML as file
     */
    @Override
    public void outARecordDescription(ARecordDescription node) {
        // TODO end
        walkTree(document);
    }

    private void walkTree(Item item) {
        item.getElement().setSettings((Copybook) document.getElement());

        for (Iterator i = item.children.iterator(); i.hasNext(); ) {
            Item child = (Item) i.next();

            if (child.redefines != null) {
                ((Copybook) document.getElement()).redefine(child.redefines, child.getElement());
            } else {
                ((Group) item.getElement()).addChild(child.getElement());
            }

            walkTree(child);
        }
    }

    /**
     * check for comments before these Tokens and add to XML
     */
    @Override
    public void caseTNumberNot88(TNumberNot88 node) {
        checkForComments(node);
    }

    @Override
    public void caseTNumber88(TNumber88 node) {
        checkForComments(node);
    }

    public void checkForComments(Token node) {
        List list = (List) parser.ignoredTokens.getIn(node);
        if (list != null) {
            Iterator i = list.iterator();
            while (i.hasNext()) {
                String s = i.next().toString().trim();
                if (s.length() > 1) {
                    // TODO
                }
            }
        }
    }

    /**
     * main elementary item enter item, set up Item object
     */
    @Override
    public void inAItem(AItem node) {
        Item prevItem = current;
        current = new Item(values, false);
        current.level = Integer.parseInt(node.getNumberNot88().toString().trim());
        current.name = node.getDataNameOrFiller().toString().trim();

        if (current.level <= 77) {
            current.setParent(prevItem);
        }
    }

    /**
     * end of parsing the element?
     */
    @Override
    public void outAItem(AItem node) {
        current.createElement();
    }

    @Override
    public void inARedefinesClause(ARedefinesClause node) {
        String dataName = node.getDataName().getText();
        current.redefines = dataName;
    }

    @Override
    public void inAFixedOccursFixedOrVariable(AFixedOccursFixedOrVariable node) {
        current.occurs = Integer.parseInt(node.getNumber().toString().trim());
    }

    @Override
    public void inAVariableOccursFixedOrVariable(AVariableOccursFixedOrVariable node) {
        current.occurs = Integer.parseInt(node.getNumber().toString().trim());
        current.dependsOn = node.getDataName().getText();
    }

    @Override
    public void inAOccursTo(AOccursTo node) {
        current.minOccurs = Integer.parseInt(node.getNumber().toString().trim());
    }

    @Override
    public void inAPictureClause(APictureClause node) {
        current.picture = removeChars(node.getCharacterString()
                .toString().toUpperCase(), " ");

        for (int i = 0; i < current.picture.length(); i++) {
            char c = current.picture.charAt(i);
            switch (c) {
                case 'A': /* alpha */
                case 'B': /* space */
                case 'X': /* number or alpha */
                case '/': /* '/' */
                case ',': /* ',' */
                    current.isAlpha = true;
                    break;
                case 'N': /* national */
                    throw new IllegalArgumentException("national data not yet supported");
                case 'E': /* exponent */
                    throw new IllegalArgumentException("E in picture String not yet supported");
                case 'G': /* ??? */
                    throw new IllegalArgumentException("G in picture String not yet supported");
                case 'P': //decimal position?
                    throw new IllegalArgumentException("P in picture String not yet supported");
                case 'C': /* CR - credit */
                case 'D': /* DR - debit */
                    /* skip R */
                    i++;
                case '.': /* decimal position */
                case 'V': /* decimal position */
                case '$': /* '$' */
                case 'Z':
                case '9':
                case '0':
                case '+':
                case '-':
                case '*':
                    break;
            }
        }
    }

    @Override
    public void inASignClause(ASignClause node) {
        if (node.getSeparateCharacter() != null) {
            current.signSeparate = true;
        }
    }

    @Override
    public void inALeadingLeadingOrTrailing(ALeadingLeadingOrTrailing node) {
        current.signPosition = SignedSeparate.LEADING;
    }

    public void inATrailimngLeadingOrTrailing(ALeadingLeadingOrTrailing node) {
        current.signPosition = SignedSeparate.TRAILING;
    }

    //======================= USAGE CLAUSE ==========================
    @Override
    public void inABinaryUsagePhrase(ABinaryUsagePhrase node) {
        current.usage = Usage.BINARY;
    }

    @Override
    public void inACompUsagePhrase(ACompUsagePhrase node) {
        current.usage = Usage.COMPUTATIONAL;
    }

    @Override
    public void inAComp1UsagePhrase(AComp1UsagePhrase node) {
        current.usage = Usage.COMPUTATIONAL_1;
    }

    @Override
    public void inAComp2UsagePhrase(AComp2UsagePhrase node) {
        current.usage = Usage.COMPUTATIONAL_2;
    }

    @Override
    public void inAComp3UsagePhrase(AComp3UsagePhrase node) {
        current.usage = Usage.COMPUTATIONAL_3;
    }

    @Override
    public void inAComp4UsagePhrase(AComp4UsagePhrase node) {
        current.usage = Usage.COMPUTATIONAL_4;
    }

    @Override
    public void inAComp5UsagePhrase(AComp5UsagePhrase node) {
        current.usage = Usage.COMPUTATIONAL_5;
    }

    @Override
    public void inADisplay1UsagePhrase(ADisplay1UsagePhrase node) {
        throw new IllegalArgumentException("display-1");
    }

    @Override
    public void inAIndexUsagePhrase(AIndexUsagePhrase node) {
        throw new IllegalArgumentException("index");
    }

    @Override
    public void inANationalUsagePhrase(ANationalUsagePhrase node) {
        throw new IllegalArgumentException("national");
    }

    @Override
    public void inAObjectReferencePhrase(AObjectReferencePhrase node) {
        throw new IllegalArgumentException("object-reference");//, node.getDataName().getText());
    }

    @Override
    public void inAPackedDecimalUsagePhrase(APackedDecimalUsagePhrase node) {
        current.usage = Usage.PACKED_DECIMAL;
    }

    @Override
    public void inAPointerUsagePhrase(APointerUsagePhrase node) {
        throw new IllegalArgumentException("pointer");
    }

    @Override
    public void inAProcedurePointerUsagePhrase(AProcedurePointerUsagePhrase node) {
        throw new IllegalArgumentException("procedure-pointer");
    }

    @Override
    public void inAFunctionPointerUsagePhrase(AFunctionPointerUsagePhrase node) {
        throw new IllegalArgumentException("function-pointer");
    }

    //	======================= 88 / VALUE CLAUSE ==========================
    @Override
    public void caseTZeros(TZeros node) {
        current.value = values.ZEROS;
    }

    @Override
    public void caseTSpaces(TSpaces node) {
        current.value = values.SPACES;
    }

    @Override
    public void caseTHighValues(THighValues node) {
        current.value = values.HIGH_VALUES;
    }

    @Override
    public void caseTLowValues(TLowValues node) {
        current.value = values.LOW_VALUES;
    }

    @Override
    public void caseTQuotes(TQuotes node) {
        current.value = values.QUOTES;
    }

    @Override
    public void caseTNulls(TNulls node) {
        current.value = values.NULLS;
    }

    @Override
    public void caseTAlphanumericLiteral(TAlphanumericLiteral node) {
        current.value = values.new Literal(node.getText());
    }

    @Override
    public void outAValueClause(AValueClause node) {
        current.value = values.new Literal(node.getLiteral().toString().trim());
    }

    // 88 LEVEL CONDITION NODE
    @Override
    public void inAValueItem(AValueItem node) {
//		String name = node.getDataName().getText();
//		curItem = new Item();
//		curItem.element = document.createElement("condition");
//		// curItem.element.setAttribute("level", "88");
//		curItem.element.setAttribute("name", name);
//		prevItem.element.appendChild(curItem.element);
        throw new IllegalArgumentException("'a value item' not yet supported");
    }

    @Override
    public void outASingleLiteralSequence(ASingleLiteralSequence node) {
//		if (node.getAll() != null) {
//			curItem.element.setAttribute("all", "true");
//		}
//		Element element = document.createElement("condition");
//		element.setAttribute("value", node.getLiteral().toString().trim());
//		curItem.element.appendChild(element);
        throw new IllegalArgumentException("'a single literal sequence' not yet supported");
    }

    @Override
    public void outASequenceLiteralSequence(ASequenceLiteralSequence node) {
//		Element element = document.createElement("condition");
//		element.setAttribute("value", node.getLiteral().toString().trim());
//		curItem.element.appendChild(element);
        throw new IllegalArgumentException("'a sequence literal sequence' not yet supported");
    }

    @Override
    public void outAThroughSingleLiteralSequence(AThroughSingleLiteralSequence node) {
//		Element element = document.createElement("condition");
//		element.setAttribute("value", node.getFrom().toString().trim());
//		element.setAttribute("through", node.getTo().toString().trim());
//		curItem.element.appendChild(element);
        throw new IllegalArgumentException("'a through single literal sequence' not yet supported");
    }

    @Override
    public void outAThroughSequenceLiteralSequence(AThroughSequenceLiteralSequence node) {
//		Element element = document.createElement("condition");
//		element.setAttribute("value", node.getFrom().toString().trim());
//		element.setAttribute("through", node.getTo().toString().trim());
//		curItem.element.appendChild(element);	
        throw new IllegalArgumentException("'a through sequence literal sequence' not yet supported");
    }

    //===============================================================================
    private String removeChars(String s, String charToRemove) {
        StringTokenizer st = new StringTokenizer(s, charToRemove, false);
        StringBuffer b = new StringBuffer();
        while (st.hasMoreElements()) {
            b.append(st.nextElement());
        }
        return b.toString();
    }

    /**
     * This is for DOM post-processing of the XML before saving to resolve the
     * field lengths of each node and also calculate the start position of the
     * data field in the raw copybook buffer (mainframe equivalent) recursive
     * traversal. note that REDEFINES declarations are taken care of as well as
     * the OCCURS declarations
     */
    int getPosition(String name) {
        List children = document.getElement().getChildren();

        for (Iterator i = children.iterator(); i.hasNext(); ) {
            Element testElement = (Element) i.next();
            if (testElement.getName().equals(name)) {
                return testElement.getPosition();
            }
        }

        throw new IllegalArgumentException("no element named '" + name + "'");
    }
}