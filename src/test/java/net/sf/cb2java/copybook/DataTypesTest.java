package net.sf.cb2java.copybook;

import junit.framework.TestCase;
import net.sf.cb2java.data.GroupData;
import net.sf.cb2java.data.Record;
import net.sf.cb2java.exceptions.DataTypeFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 *
 */
public class DataTypesTest extends TestCase {

    public DataTypesTest(String testName) {
        super(testName);
    }

    /**
     * Take a copybook and parse it.
     *
     * @throws FileNotFoundException
     */
    public void testWeCanParseAlpha() throws IOException, DataTypeFormatException {
        Copybook copybook = CopybookParser.parse("TYPES", new FileInputStream(new File("./src/test/resources/types.copybook")));
        assertEquals(16, copybook.getLength());
        List<Record> records = copybook.parseData(new FileInputStream(new File("./src/test/resources/types.txt")));
        Record record = records.get(0);
        assertEquals("!", record.getChild("TYPES").getChildren().get(0).getChildren().get(0).toString());
        assertEquals(">--------<", record.getChild("TYPES").getChildren().get(0).getChildren().get(1).toString());
    }

    public void testWeCanParseIntegers() throws IOException, DataTypeFormatException {
        Copybook copybook = CopybookParser.parse("TYPES", new FileInputStream(new File("./src/test/resources/types.copybook")));
        List<Record> records = copybook.parseData(new FileInputStream(new File("./src/test/resources/types.txt")));
        Record record = records.get(0);
        GroupData integers = (GroupData) record.getChild("TYPES").getChildren().get(1);
        assertEquals(BigInteger.ZERO, integers.getChild("ZEROH").getValue());
        assertEquals(BigInteger.ONE, integers.getChild("ONE").getValue());
        assertEquals(BigInteger.valueOf(9), integers.getChild("NINE").getValue());
    }

    public void testWeCanParseNegativeIntegers() throws IOException, DataTypeFormatException {
        Copybook copybook = CopybookParser.parse("TYPES", new FileInputStream(new File("./src/test/resources/types.copybook")));
        List<Record> records = copybook.parseData(new FileInputStream(new File("./src/test/resources/types.txt")));
        Record record = records.get(0);
        GroupData integers = (GroupData) record.getChild("TYPES").getChildren().get(1);
        // todo assertEquals(BigInteger.valueOf(-1),  integers.getChild("MINUSONE").getValue());
        // todo assertEquals(BigInteger.valueOf(-65), integers.getChild("MINUSSIXTYFIVE").getValue());
        // todo assertEquals(BigInteger.valueOf(-82), integers.getChild("EIGHTYTWO").getValue());
    }

}