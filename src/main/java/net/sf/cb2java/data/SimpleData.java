package net.sf.cb2java.data;

import net.sf.cb2java.types.SimpleElement;

/**
 * Simple representation of data
 */
public interface SimpleData extends SimpleElement {

    Object getValue();

    /**
     * Converts values of all leafs to a byte array
     *
     * @return Values as bytes
     */
    byte[] getBytes();

}
