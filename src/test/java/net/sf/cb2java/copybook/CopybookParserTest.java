package net.sf.cb2java.copybook;

import junit.framework.TestCase;
import net.sf.cb2java.data.Data;
import net.sf.cb2java.data.Record;
import net.sf.cb2java.data.RecordData;
import net.sf.cb2java.types.CopybookElement;
import net.sf.cb2java.types.Type;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author devstopfix
 */
public class CopybookParserTest extends TestCase {
    
    public CopybookParserTest(String testName) {
        super(testName);
    }

    /**
     * Take a copybook and parse it.
     *
     * @throws FileNotFoundException
     */
    public void testWeCanParseCopybook() throws FileNotFoundException {
        Copybook copybook = CopybookParser.parse("A", new FileInputStream(new File("./target/test-classes/a.copybook")));
        assertEquals(55, copybook.getLength());
    }

    /**
     * Parse copybook data to a POJO tree structure
     *
     * @throws FileNotFoundException
     */
    public void testWeCanParseCopybookAsTree() throws FileNotFoundException {
        Copybook copybook = CopybookParser.parse("A", new FileInputStream(new File("./target/test-classes/a.copybook")));
        CopybookElement element = copybook.toPojo().getChildren().get(0);
        List<CopybookElement> children = element.getChildren();

        assertEquals("ROOT", element.getName());
        assertNull(element.getType());
        assertEquals(55, element.getLength());

        CopybookElement a = children.get(0);
        assertEquals("A", a.getName());
        assertEquals(Type.ALPHA_NUMERIC, a.getType());
        assertEquals(6, a.getLength());

        CopybookElement b = children.get(1);
        assertEquals("B", b.getName());
        assertEquals(Type.ALPHA_NUMERIC, b.getType());
        assertEquals(4, b.getLength());

        CopybookElement c = children.get(2);
        assertEquals("C", c.getName());
        assertEquals(Type.DECIMAL, c.getType());
        assertEquals(5, c.getLength());

        CopybookElement d = children.get(3);
        assertEquals("D", d.getName());
        assertEquals(Type.DECIMAL, d.getType());
        assertEquals(4, d.getLength());

        CopybookElement sub = children.get(4);
        assertEquals("SUB", sub.getName());
        assertNull(sub.getType());
        assertEquals(6, sub.getLength());

        CopybookElement e = children.get(4).getChildren().get(0);
        assertEquals("E", e.getName());
        assertEquals(Type.ALPHA_NUMERIC, e.getType());
        assertEquals(3, e.getLength());

        CopybookElement f = children.get(4).getChildren().get(1);
        assertEquals("F", f.getName());
        assertEquals(Type.ALPHA_NUMERIC, f.getType());
        assertEquals(3, f.getLength());

        CopybookElement g = children.get(5);
        assertEquals("G", g.getName());
        assertEquals(Type.BINARY, g.getType());
        assertEquals(4, g.getLength());

        CopybookElement h = children.get(6);
        assertEquals("H", h.getName());
        assertEquals(Type.PACKED, h.getType());
        assertEquals(4, h.getLength());

        CopybookElement i = children.get(7);
        assertEquals("I", i.getName());
        assertEquals(Type.FLOATING, i.getType());
        assertEquals(4, i.getLength());

        CopybookElement j = children.get(8);
        assertEquals("J", j.getName());
        assertEquals(Type.FLOATING, j.getType());
        assertEquals(8, j.getLength());

        CopybookElement k = children.get(9);
        assertEquals("K", k.getName());
        assertEquals(Type.BINARY, k.getType());
        assertEquals(4, k.getLength());
    }
    
    /**
     * Parse copybook data.
     *
     * @throws FileNotFoundException
     */
    public void testWeCanParseCopybookData() throws FileNotFoundException, IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        assertEquals(31, copybook.getLength());
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        System.out.println("Definitions:");
        for(Record record : results) {
            record.toPOJOTree();
        }
        assertEquals(1, results.size());
        Record record = results.get(0);
        Data root = record.getChild("ROOT");
        assertEquals("ABCDEF", root.getChildren().get(0).toString());
        assertEquals("B", ((Data)root.getChildren().get(1)).getName().toString());
        assertEquals("BCDE", root.getChildren().get(1).toString());
        // TODO assertEquals(12345, root.getChildren().get(2).toString());
        // TODO assertEquals(1234, ((Data)root.getChildren().get(3)).getValue());
        System.out.println(root.toString());
    }
    
    /**
     * Parse copybook data to a Map.
     *
     * @throws FileNotFoundException
     */
    public void testWeCanParseCopybookDataAsMap() throws FileNotFoundException, IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        Map<String,Object>record = results.get(0).toMap();
        assertTrue(record.containsKey("ROOT"));
        //assertEquals("ABCDEF", root.getChildren().get(0).toString());
        //assertEquals("B", ((Data)root.getChildren().get(1)).getName().toString());
        //assertEquals("BCDE", root.getChildren().get(1).toString());
        // TODO assertEquals(12345, root.getChildren().get(2).toString());
        // TODO assertEquals(1234, ((Data)root.getChildren().get(3)).getValue());
    }

    /**
     * Parse copybook data to a POJO tree.
     *
     * @throws FileNotFoundException
     */
    public void testWeCanParseCopybookDataAsTree() throws FileNotFoundException, IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        RecordData root = (RecordData) results.get(0).toPOJOTree().getChildren().get(0);

        assertEquals("ROOT", root.getName());
        assertEquals(31, root.getLength());
        assertNull(root.getValue());
        assertEquals(10, root.getLevel());
        assertNull(root.getType());

        List<RecordData> children = root.getChildrenAsRecordData();

        RecordData a = children.get(0);
        assertEquals("A", a.getName());
        assertEquals(6, a.getLength());
        assertEquals("ABCDEF", a.getValue());
        assertEquals(15, a.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, a.getType());

        RecordData b = children.get(1);
        assertEquals("B", b.getName());
        assertEquals(4, b.getLength());
        assertEquals("BCDE", b.getValue());
        assertEquals(15, b.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, b.getType());

        RecordData c = children.get(2);
        assertEquals("C", c.getName());
        assertEquals(5, c.getLength());
        assertEquals(BigInteger.valueOf(12345), c.getValue());
        assertEquals(15, c.getLevel());
        assertEquals(Type.DECIMAL, c.getType());

        RecordData d = children.get(3);
        assertEquals("D", d.getName());
        assertEquals(4, d.getLength());
        assertEquals(BigInteger.valueOf(1234), d.getValue());
        assertEquals(15, d.getLevel());
        assertEquals(Type.DECIMAL, d.getType());

        RecordData sub1 = children.get(4);
        assertEquals("SUB", sub1.getName());
        assertEquals(6, sub1.getLength());
        assertNull(sub1.getValue());
        assertEquals(15, sub1.getLevel());
        assertNull(sub1.getType());

        RecordData e1 = sub1.getChildrenAsRecordData().get(0);
        assertEquals("E", e1.getName());
        assertEquals(3, e1.getLength());
        assertEquals("E", e1.getValue());
        assertEquals(20, e1.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, e1.getType());

        RecordData f1 = sub1.getChildrenAsRecordData().get(1);
        assertEquals("F", f1.getName());
        assertEquals(3, f1.getLength());
        assertEquals("FF", f1.getValue());
        assertEquals(20, f1.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f1.getType());

        RecordData sub2 = children.get(5);
        RecordData e2 = sub2.getChildrenAsRecordData().get(0);
        assertEquals("E", e2.getName());
        assertEquals(3, e2.getLength());
        assertEquals("EEE", e2.getValue());
        assertEquals(20, e2.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, e2.getType());

        RecordData f2 = sub2.getChildrenAsRecordData().get(1);
        assertEquals("F", f2.getName());
        assertEquals(3, f2.getLength());
        assertEquals("FFF", f2.getValue());
        assertEquals(20, f2.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f2.getType());
    }
    
    public void testRightTrimOfPICXfields() throws FileNotFoundException, IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        Map<String,Object>record = results.get(0).toMap();
        
        // TODO assertEquals(" E", record.get(0).toString());
        // TODO assertEquals("FF", record.get(1).toString());
    }
    
    public void testOccursAsList() throws FileNotFoundException, IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        assertEquals(31, copybook.getLength());
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        Map<String,Object>record = results.get(0).toMap();
        List sub = (List) ((Map)record.get("ROOT")).get("SUB");
        assertEquals(2, sub.size());
        assertEquals("EEE", ((Map)sub.get(1)).get("E").toString());
        assertEquals("FFF", ((Map)sub.get(1)).get("F").toString());
        System.out.println(record.toString());
        System.out.println(Arrays.toString(sub.toArray()));
    }
    
}
