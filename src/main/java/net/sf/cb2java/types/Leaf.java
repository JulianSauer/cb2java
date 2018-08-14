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

import java.util.Collections;
import java.util.List;

/**
 * Base class for elements that are not group elements
 *
 * @author Matt Watson
 */
abstract class Leaf extends Element {
    protected Leaf(String name, int level, final int occurs) {
        super(name, level, occurs);
    }

    /**
     * returns an empty collection
     *
     * @return an empty collection
     */
    public List<Element> getChildren() {
        return Collections.EMPTY_LIST;
    }
}