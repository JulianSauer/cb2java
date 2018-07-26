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

import net.sf.cb2java.types.Element;
import net.sf.cb2java.types.Type;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * The base type for all Data elements
 *
 * @author James Watson
 */
public abstract class Data implements SimpleData {

    private final Element definition;

    /**
     * constructor
     *
     * @param definition the underlying type definition
     */
    public Data(final Element definition) {
        this.definition = definition;
    }

    public abstract boolean isLeaf();

    /**
     * returns all the children of this item, if there are any
     */
    public abstract List<Data> getChildren();

    /**
     * gives a string representation of this element
     * with the given indention
     *
     * @param indent the string used to indent
     */
    public abstract String toString(String indent);

    /**
     * the underlying type definition of the element
     */
    public Element getDefinition() {
        return definition;
    }

    /**
     * Sets the internal value of this item.  If the data is not
     * compatible with this type, an Exception will be thrown.  See
     * the documentation of the specific subtypes for a list of 
     * acceptable types and other rules for valid input.
     *
     * @param data the data to set.  Must be compatible with the
     * the instance.
     */
    public final void setValue(Object data) {
        //TODO setting?
//        validate(data);

        setValueImpl(data);
    }

    public final void setValue(String data) {
        setValue(translate(data));
    }

    public abstract Object translate(String data);

    /**
     * called by setData after validate is called
     *
     * @param data the data to set
     */
    protected abstract void setValueImpl(Object data);

    /**
     * @param stream
     * @throws IOException
     */
    public void write(OutputStream stream) throws IOException {
        getDefinition().write(stream, getValue());
    }

    /**
     * Validates the data passed in using the underlying definition
     *
     * @param data the data to validate
     */
    public final void validate(Object data) {
        getDefinition().validate(data);
    }

    @Override
    public String getName() {
        return getDefinition().getName();
    }

    @Override
    public int getLevel() {
        return getDefinition().getLevel();
    }

    @Override
    public Type getType() {
        return getDefinition().getType();
    }

    @Override
    public int getOccurs() {
        return getDefinition().getOccurs();
    }

    @Override
    public int getLength() {
        return getDefinition().getLength();
    }

    /**
     * Convert the copybook data types into standard Java structures
     * and objects.
     *
     * <li>Groups become Maps
     * <li>Occurs use Lists
     * <li>PICX become Strings
     * <li>PIC9 become Integers or BigDecimals
     *
     * @author github.com/devstopfix/cb2java
     *
     * @return the copybook data as Plain Java Objects
     */
    protected abstract Object toPOJO();
}