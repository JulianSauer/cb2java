package net.sf.cb2java.copybook;

import junit.framework.TestCase;
import net.sf.cb2java.data.Data;
import net.sf.cb2java.data.Record;
import net.sf.cb2java.data.SimpleData;
import net.sf.cb2java.types.SimpleElement;
import net.sf.cb2java.types.Type;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
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
        SimpleElement element = copybook.getChildren().get(0);
        List<SimpleElement> children = (List<SimpleElement>) element.getChildren();

        assertEquals("ROOT", element.getName());
        assertNull(element.getType());
        assertEquals(55, element.getLength());

        SimpleElement a = children.get(0);
        assertEquals("A", a.getName());
        assertEquals(Type.ALPHA_NUMERIC, a.getType());
        assertEquals(6, a.getLength());

        SimpleElement b = children.get(1);
        assertEquals("B", b.getName());
        assertEquals(Type.ALPHA_NUMERIC, b.getType());
        assertEquals(4, b.getLength());

        SimpleElement c = children.get(2);
        assertEquals("C", c.getName());
        assertEquals(Type.DECIMAL, c.getType());
        assertEquals(5, c.getLength());

        SimpleElement d = children.get(3);
        assertEquals("D", d.getName());
        assertEquals(Type.DECIMAL, d.getType());
        assertEquals(4, d.getLength());

        SimpleElement sub = children.get(4);
        assertEquals("SUB", sub.getName());
        assertNull(sub.getType());
        assertEquals(6, sub.getLength());

        SimpleElement e = sub.getChildren().get(0);
        assertEquals("E", e.getName());
        assertEquals(Type.ALPHA_NUMERIC, e.getType());
        assertEquals(3, e.getLength());

        SimpleElement f = sub.getChildren().get(1);
        assertEquals("F", f.getName());
        assertEquals(Type.ALPHA_NUMERIC, f.getType());
        assertEquals(3, f.getLength());

        SimpleElement g = children.get(5);
        assertEquals("G", g.getName());
        assertEquals(Type.BINARY, g.getType());
        assertEquals(4, g.getLength());

        SimpleElement h = children.get(6);
        assertEquals("H", h.getName());
        assertEquals(Type.PACKED, h.getType());
        assertEquals(4, h.getLength());

        SimpleElement i = children.get(7);
        assertEquals("I", i.getName());
        assertEquals(Type.FLOATING, i.getType());
        assertEquals(4, i.getLength());

        SimpleElement j = children.get(8);
        assertEquals("J", j.getName());
        assertEquals(Type.FLOATING, j.getType());
        assertEquals(8, j.getLength());

        SimpleElement k = children.get(9);
        assertEquals("K", k.getName());
        assertEquals(Type.BINARY, k.getType());
        assertEquals(4, k.getLength());
    }

    /**
     * Parse copybook data.
     *
     * @throws IOException
     */
    public void testWeCanParseCopybookData() throws IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        SimpleData root = results.get(0).getChildren().get(0);

        assertEquals("ROOT", root.getName());
        assertEquals(31, root.getLength());
        assertNull(root.getValue());
        assertEquals(10, root.getLevel());
        assertNull(root.getType());

        List<SimpleData> children = (List<SimpleData>) root.getChildren();

        SimpleData a = children.get(0);
        assertEquals("A", a.getName());
        assertEquals(6, a.getLength());
        assertEquals("ABCDEF", a.getValue());
        assertEquals(15, a.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, a.getType());

        SimpleData b = children.get(1);
        assertEquals("B", b.getName());
        assertEquals(4, b.getLength());
        assertEquals("BCDE", b.getValue());
        assertEquals(15, b.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, b.getType());

        SimpleData c = children.get(2);
        assertEquals("C", c.getName());
        assertEquals(5, c.getLength());
        assertEquals(BigInteger.valueOf(12345), c.getValue());
        assertEquals(15, c.getLevel());
        assertEquals(Type.DECIMAL, c.getType());

        SimpleData d = children.get(3);
        assertEquals("D", d.getName());
        assertEquals(4, d.getLength());
        assertEquals(BigInteger.valueOf(1234), d.getValue());
        assertEquals(15, d.getLevel());
        assertEquals(Type.DECIMAL, d.getType());

        SimpleData sub1 = children.get(4);
        assertEquals("SUB", sub1.getName());
        assertEquals(6, sub1.getLength());
        assertNull(sub1.getValue());
        assertEquals(15, sub1.getLevel());
        assertNull(sub1.getType());

        SimpleData e1 = (SimpleData) sub1.getChildren().get(0);
        assertEquals("E", e1.getName());
        assertEquals(3, e1.getLength());
        assertEquals(" E", e1.getValue());
        assertEquals(20, e1.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, e1.getType());

        SimpleData f1 = (SimpleData) sub1.getChildren().get(1);
        assertEquals("F", f1.getName());
        assertEquals(3, f1.getLength());
        assertEquals("FF", f1.getValue());
        assertEquals(20, f1.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f1.getType());

        SimpleData sub2 = children.get(5);
        SimpleData e2 = (SimpleData) sub2.getChildren().get(0);
        assertEquals("E", e2.getName());
        assertEquals(3, e2.getLength());
        assertEquals("EEE", e2.getValue());
        assertEquals(20, e2.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, e2.getType());

        SimpleData f2 = (SimpleData) sub2.getChildren().get(1);
        assertEquals("F", f2.getName());
        assertEquals(3, f2.getLength());
        assertEquals("FFF", f2.getValue());
        assertEquals(20, f2.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f2.getType());
    }

    public void testWeCanParseCopybookAsByteArray() throws IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));

        byte[] bufferB = Files.readAllBytes(new File("./target/test-classes/b.input.txt").toPath());
        List<Record> resultsB = copybook.parseData(bufferB);
        SimpleData rootB = resultsB.get(0).getChildren().get(0);

        assertEquals("ROOT", rootB.getName());
        assertEquals(31, rootB.getLength());
        assertNull(rootB.getValue());
        assertEquals(10, rootB.getLevel());
        assertNull(rootB.getType());


        byte[] bufferC = Files.readAllBytes(new File("./target/test-classes/c.input.txt").toPath());
        List<Record> resultsC = copybook.parseData(bufferC);

        assertEquals(3, resultsC.size());

        SimpleData rootC1 = resultsC.get(0).getChildren().get(0);
        SimpleData sub1 = (SimpleData) rootC1.getChildren().get(5);
        SimpleData f1 = (SimpleData) sub1.getChildren().get(1);
        assertEquals("F", f1.getName());
        assertEquals(3, f1.getLength());
        assertEquals("FFF", f1.getValue());
        assertEquals(20, f1.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f1.getType());

        SimpleData rootC2 = resultsC.get(1).getChildren().get(0);
        SimpleData sub2 = (SimpleData) rootC2.getChildren().get(5);
        SimpleData f2 = (SimpleData) sub2.getChildren().get(1);
        assertEquals("F", f2.getName());
        assertEquals(3, f2.getLength());
        assertEquals("EEE", f2.getValue());
        assertEquals(20, f2.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f2.getType());

        SimpleData rootC3 = resultsC.get(2).getChildren().get(0);
        SimpleData sub3 = (SimpleData) rootC3.getChildren().get(5);
        SimpleData f3 = (SimpleData) sub3.getChildren().get(1);
        assertEquals("F", f3.getName());
        assertEquals(3, f3.getLength());
        assertEquals("FFF", f3.getValue());
        assertEquals(20, f3.getLevel());
        assertEquals(Type.ALPHA_NUMERIC, f3.getType());
    }

    public void testWeCanParseCopybookAsString() throws IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        byte[] buffer = Files.readAllBytes(new File("./target/test-classes/b.input.txt").toPath());
        String data = new String(buffer, StandardCharsets.UTF_8);

        List<Record> resultsString = copybook.parseData(data);
        List<Record> resultsByte = copybook.parseData(buffer);
        assertEquals(resultsString.toString(), resultsByte.toString());
    }

    public void testRightTrimOfPICXfields() throws FileNotFoundException, IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));
        List<Data> groupData = results.get(0).getChildren().get(0).getChildren().get(4).getChildren();

        assertEquals(" E", groupData.get(0).toString());
        assertEquals("FF", groupData.get(1).toString());
    }

}
