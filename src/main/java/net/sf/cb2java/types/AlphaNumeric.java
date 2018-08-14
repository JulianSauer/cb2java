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
package net.sf.cb2java.types;

import net.sf.cb2java.Value;

import java.util.regex.Pattern;

/**
 * Class used to represent alpha and alphanumeric
 * data types
 *
 * @author James Watson
 */
public class AlphaNumeric extends Characters {

    /**
     * the original pattern used for debugging
     */
    private final String originalPattern;

    /**
     * the regex pattern for validation
     */
    private final Pattern pattern;

    /**
     * the byte length of this element
     */
    private final int length;

    public AlphaNumeric(String name, int level, int occurs, String pattern) {
        super(name, 0, level, occurs);

        this.originalPattern = pattern;
        pattern = pattern.toUpperCase();

        StringBuffer buffer = new StringBuffer();

        length = parsePattern(pattern, buffer);

        this.pattern = Pattern.compile(buffer.toString());

        type = Type.ALPHA_NUMERIC;
    }

    public AlphaNumeric(String pattern) {
        this("", 0, 1, pattern);
    }

    private static int parsePattern(String pattern, StringBuffer buffer) {
        boolean open = false;
        int length = 0;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (c == '(') {
                int pos = pattern.indexOf(')', i);
                int times = Integer.parseInt(pattern.substring(i + 1, pos));
                buffer.append('{').append(times).append('}');
                i = pos + 1;
                length += times;
                open = false;
            } else {
                if (open) length++;
                buffer.append(forChar(c));
                open = true;
            }
        }

        if (open) length++;

        return length;
    }

    private static String forChar(char c) {
        switch (c) {
            case 'A':
                return "[a-zA-Z\u0000 ]";
            case 'X':
                return ".";//[a-zA-Z0-9\u0000 ]
            case '9':
                return "[0-9\u0000 ]";
            default:
                throw new IllegalArgumentException("character [" + c + "] not allowed.");
        }
    }

    @Override
    public int getLength() {
        return length;
    }

    /**
     * returns the pattern used to validate the element
     *
     * @return the pattern used to validate the element
     */
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public void validate(Object data) {
        if (data == null) return;

        String s = (String) data;

        if (!pattern.matcher(getValue().fillString(s, getLength(), Value.RIGHT)).matches()) {
            System.out.print(pattern.toString());
            throw new IllegalArgumentException(data + " does not match pattern '" + originalPattern
                    + "' specified for " + getName());
        }
    }

}