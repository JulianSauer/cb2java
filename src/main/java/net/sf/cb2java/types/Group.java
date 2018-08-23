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
import net.sf.cb2java.data.Data;
import net.sf.cb2java.data.GroupData;
import net.sf.cb2java.exceptions.DataTypeFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Type used to represent an element with child elements
 */
public class Group extends Element {

    /**
     * the list of children
     */
    private final List<Element> children = new ArrayList<>();

    /**
     * the wrapper list exposed through getChildren()
     */
    private final List<Element> wrapper = Collections.unmodifiableList(children);

    public Group(final String name, final int level, final int occurs) {
        super(name, level, occurs);
    }

    public void addChild(Element element) {
        children.add(element);
        element.setParent(this);
    }

    /**
     * returns an immutable list of the children in this group.
     */
    @Override
    public List<Element> getChildren() {
        return wrapper;
    }

    @Override
    public int getLength() {
        int length = 0;

        for (Element element : children) {
            for (int j = 0; j < element.getOccurs(); j++) {
                length += element.getLength();
            }
        }

        return length;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        buffer.append(super.toString());

        for (Element aChildren : children)
            buffer.append(aChildren);

        return buffer.toString();
    }

    @Override
    public Data create() {
        List<Data> dataChildren = new ArrayList<>();

        for (Element element : children) {
            for (int j = 0; j < element.getOccurs(); j++) {
                dataChildren.add(element.create());
            }
        }

        return new GroupData(this, dataChildren);
    }

    @Override
    public Data parse(final byte[] bytes) throws DataTypeFormatException {
        List<Data> dataChildren = new ArrayList<>();

        int pos = 0;

        for (Element element : children) {
            for (int j = 0; j < element.getOccurs(); j++) {
                final int end = pos + element.getLength();
                byte[] sub = Arrays.copyOfRange(bytes, pos, end);
                dataChildren.add(element.parse(sub));
                pos = end;
            }
        }

        return new GroupData(this, dataChildren);
    }

    @Override
    public byte[] toBytes(Object data) {
        throw new IllegalArgumentException("cannot read bytes from a group");
    }

    @Override
    public void validate(Object data) {
        throw new IllegalArgumentException("groups do not accept data");
    }

    @Override
    public Value getValue() {
        throw new RuntimeException("groups cannot have a value");
    }

    @Override
    public void setValue(Value value) {
        throw new RuntimeException("groups cannot have a value");
    }
}