package net.sf.cb2java.data;

import junit.framework.TestCase;
import net.sf.cb2java.copybook.Copybook;
import net.sf.cb2java.copybook.CopybookParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author Julian Sauer
 */
public class DataConverterTest extends TestCase {

    public void testFileSaving() throws IOException {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        List<Record> results = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.input.txt")));

        DataConverter converter = new DataConverter();
        File file = new File("./target/test-classes/b.output.txt");
        file.getParentFile().mkdirs();
        file.createNewFile();
        converter.toFile(file, results);

        List<Record> createdResults = copybook.parseData(new FileInputStream(new File("./target/test-classes/b.output.txt")));
        assertEquals(results.toString(), createdResults.toString());
    }

}
