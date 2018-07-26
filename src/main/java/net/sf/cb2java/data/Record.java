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

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

public class Record extends GroupData {
    public Record(GroupData data) {
        super(data.definition, data.children);
    }

    public JsonElement toJson() {
        Map<String, Object> group = new HashMap<>(getChildren().size());
        for (Data child : getChildren())
            group.put(child.getName(), child.toPOJO());
        return new Gson().toJsonTree(group);
    }

}