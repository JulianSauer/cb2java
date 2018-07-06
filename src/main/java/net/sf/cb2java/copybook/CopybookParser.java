/**
 * cb2java - Dynamic COBOL copybook parser for Java.
 * Copyright (C) 2006 James Watson
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 1, or (at your option)
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package net.sf.cb2java.copybook;

import net.sf.cb2xml.DebugLexer;
import net.sf.cb2xml.sablecc.lexer.Lexer;
import net.sf.cb2xml.sablecc.node.Start;
import net.sf.cb2xml.sablecc.parser.Parser;

import java.io.*;

/**
 *
 * This class is the starting point for parsing copybooks
 *
 * <p>To parse or create data, you need to first parse the
 * copybook.  The returned CopyBook instance will allow for 
 * working with data.
 *
 * @author James Watson
 */
public class CopybookParser {
    /** turns debugging on/off I want to replace this with a logging solution */
    private static boolean debug = false;

    /**
     * Parses a copybook definition and returns a Copybook instance
     *
     * @param name the name of the copybook.  For future use.
     * @param stream the copybook definition's source stream
     *
     * @return a copybook instance containing the parse tree for the definition
     */
    public static Copybook parse(String name, InputStream stream) {
        return parse(name, new InputStreamReader(stream));
    }

    /**
     * Parses a copybook definition and returns a Copybook instance
     *
     * @param name the name of the copybook.  For future use.
     * @param reader the copybook definition's source reader
     *
     * @return a copybook instance containing the parse tree for the definition
     */
    public static Copybook parse(String name, Reader reader) {
        Copybook document = null;
        Lexer lexer = null;
        try {
            String preProcessed = CobolPreprocessor.preProcess(reader);
            StringReader sr = new StringReader(preProcessed);
            PushbackReader pbr = new PushbackReader(sr, 1000);

            if (debug) {
                lexer = new DebugLexer(pbr);
            } else {
                lexer = new Lexer(pbr);
            }

            Parser parser = new Parser(lexer);
            Start ast = parser.parse();
            CopybookAnalyzer copyBookAnalyzer = new CopybookAnalyzer(name, parser);
            ast.apply(copyBookAnalyzer);
            document = copyBookAnalyzer.getDocument();
        } catch (Exception e) {
            throw new RuntimeException("fatal parse error\n"
                    + (lexer instanceof DebugLexer
                    ? "=== buffer dump start ===\n"
                    + ((DebugLexer) lexer).getBuffer()
                    + "\n=== buffer dump end ===" : ""), e);
        }

        return document;
    }
}