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
package net.sf.cb2java;

import java.io.UnsupportedEncodingException;

public class Values {
    protected String encoding;

    public Values() {
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;

        try {
            ((StringBasedValue) SPACES).bite = " ".getBytes(encoding)[0];
            ((StringBasedValue) QUOTES).bite = "\"".getBytes(encoding)[0];
            ((StringBasedValue) ZEROS).bite = "0".getBytes(encoding)[0];
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public class Literal extends Value {
        private final String value;

        public Literal(final String value) {
            super(encoding);
            this.value = value;
        }

        @Override
        public byte[] get(int length) {
            String s = value.length() > length ? value.substring(0, length) : value;

            try {
                return s.getBytes(encoding);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        public byte getByte() {
            return 0;
        }
    }

    private class StringBasedValue extends Value {
        public StringBasedValue(Values parent) {
            super(encoding);
        }

        byte bite;

        public byte getByte() {
            return bite;
        }
    }

    public final Value SPACES = new StringBasedValue(Values.this);

    public final Value LOW_VALUES = new Value(encoding) {

        public byte getByte() {
            return 0;
        }
    };

    public final Value HIGH_VALUES = new Value(encoding) {

        public byte getByte() {
            return -1;
        }
    };

    public final Value ZEROS = new StringBasedValue(Values.this);

    public final Value QUOTES = new StringBasedValue(Values.this);

    public final Value NULLS = LOW_VALUES;
}