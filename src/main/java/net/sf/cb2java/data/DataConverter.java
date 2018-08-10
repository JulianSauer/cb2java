package net.sf.cb2java.data;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for converting parsed data back to bytes
 *
 * @author Julian Sauer
 */
public class DataConverter {

    public void toFile(File file, List<? extends Data> data) throws IOException {
        byte[] content = asByteArray(data);
        Files.write(file.toPath(), content);
    }

    public byte[] asByteArray(List<? extends Data> data) throws IOException {
        List<Byte> bytes = new ArrayList<>();
        for (Data child : data) {
            for (byte b : child.getBytes())
                bytes.add(b);
        }
        return ArrayUtils.toPrimitive(bytes.toArray(new Byte[0]));
    }

}
