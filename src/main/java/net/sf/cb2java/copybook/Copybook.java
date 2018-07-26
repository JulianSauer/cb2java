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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.sf.cb2java.Settings;
import net.sf.cb2java.Values;
import net.sf.cb2java.data.GroupData;
import net.sf.cb2java.data.Record;
import net.sf.cb2java.types.Element;
import net.sf.cb2java.types.Group;
import net.sf.cb2java.types.Numeric;
import net.sf.cb2java.types.Numeric.Position;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a copybook data definition in memory
 *
 * <p>acts as a Group element but as a special parent
 * being the copybook itself
 *
 * @author James Watson
 */
public class Copybook extends Group implements Settings {
    private String encoding = Settings.DEFAULT.getEncoding();
    private boolean littleEndian = Settings.DEFAULT.getLittleEndian();
    private String floatConversion = Settings.DEFAULT.getFloatConversion();
    private Numeric.Position signPosition = Settings.DEFAULT.getSignPosition();

    private Map redefines = new HashMap();

    private final Values values;

    /**
     * constructor
     *
     * @param name the name of the copybook
     */
    Copybook(String name, Values values) {
        super(name, 0, 0);

        this.values = values;
        values.setEncoding(encoding);
    }

    public Values getValues() {
        return values;
    }

    /**
     * redefined an element.  This behavior is partial, untested and
     * not officially supported (yet)
     *
     * @param main the name of the original element
     * @param alias the new name
     */
    void redefine(String main, Element alias) {
        redefines.put(main, alias);
    }

    /**
     * Gets an aliased element. This behavior is partial, untested and
     * not officially supported (yet)
     *
     * @param name i'm not even sure anymore
     * @return who knows?
     */
    public Element getAliased(String name) {
        return (Element) redefines.get(name);
    }

    /**
     * creates a new empty application data instance
     *
     * @return a new empty application data instance
     */
    public Record createNew() {
        return new Record((GroupData) super.create());
    }

    /**
     * creates a new application data element with the given data
     *
     * @param data the data to create the instance for
     * @return a new application data element with the given data
     * @throws IOException
     */
    public Record parseData(byte[] data) throws IOException {
        return new Record((GroupData) parse(data));
    }

    public List<Record> parseData(InputStream stream) throws IOException {
        BufferedInputStream bufferedStream = new BufferedInputStream(stream);
        List<Record> list = new ArrayList<>();

        int size = getLength();
        byte[] buffer = new byte[size];
        while (bufferedStream.read(buffer, 0, size) != -1) {
            list.add(new Record((GroupData) parse(buffer)));
        }

        return list;
    }

    public String parseDataToJson(InputStream stream) throws IOException {
        List<JsonElement> records = new ArrayList<>();
        for (Record record : parseData(stream)) {
            records.add(record.toJson());
        }
        return new Gson().toJson(records);
    }

    /**
     * Sets the encoding for the copybook instance, used for parsing
     * and writing of data
     *
     * @param encoding the encoding for the system
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * retrieves the current encoding for text
     *
     * @return the encoding for text
     */
    public String getEncoding() {
        return encoding;
    }

    public void setLittleEndian(boolean littleEndian) {
        this.littleEndian = littleEndian;
    }

    public boolean getLittleEndian() {
        return littleEndian;
    }

    public void setFloatConversion(String className) {
        this.floatConversion = className;
    }

    public String getFloatConversion() {
        return floatConversion;
    }

    public void getSignPosition(Position position) {
        this.signPosition = position;
    }

    public Position getSignPosition() {
        return signPosition;
    }

}