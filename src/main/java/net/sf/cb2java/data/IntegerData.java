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
package net.sf.cb2java.data;

import net.sf.cb2java.types.Numeric;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * class that represents numeric data 
 * with no fraction portion
 *
 * @author James Watson
 */
public class IntegerData extends NumericData {
    public BigInteger data;

    public IntegerData(Numeric definition) {
        super(definition);
    }

    @Override
    public byte[] getBytes() {
        return data.toString().getBytes();
    }

    public int getInt() {
        return data == null ? 0 : data.intValue();
    }

    public long getLong() {
        return data == null ? 0 : data.longValue();
    }

    public BigInteger getBigInteger() {
        return data == null ? new BigInteger("0") : data;
    }

    public void setValue(long data) {
        BigInteger temp = BigInteger.valueOf(data);
        setValue(temp, true);
    }

    protected void setValueImpl(Object data) {
        setValue(((BigDecimal) data).toBigInteger(), false);
    }

    public void setValue(BigInteger data) {
        setValue(data, true);
    }

    public void setValue(BigInteger data, boolean validate) {
        if (validate) validate(data);
        this.data = data;
    }

    public Object getValue() {
        return getBigInteger();
    }

    /**
     * Adds leading zeros to match number of digits from the definition
     */
    @Override
    public String toString() {
        int length = getDefinition().getLength();
        StringBuilder data = new StringBuilder(getBigInteger().toString());
        int difference = length - data.length();
        for (; difference > 0; difference--)
            data.insert(0, "0");
        return data.toString();
    }

    /**
     * Convert the copybook data types into standard Java structures
     * and objects.
     *
     * @author github.com/devstopfix/cb2java
     * @return the copybook data as Plain Java Objects
     */
    @Override
    protected Object toPOJO() {
        return this.getBigInteger();
    }
}