package net.sf.cb2java.data;

import net.sf.cb2java.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple representation of data
 */ 
public class RecordData {

    private String name;

    private Object value;

    private Type type;

    private List<RecordData> children;

    public RecordData() {
        this.name = "";
        this.children = new ArrayList<>(0);
    }

    public RecordData(String name, Object value, List<RecordData> children) {
        this.name = name;
        this.value = value;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLength() {
        if (type == null)
            return 0;
        return type.getLength();
    }

    public List<RecordData> getChildren() {
        return children;
    }

    public void setChildren(List<RecordData> children) {
        this.children = children;
    }

    public void addChild(RecordData child) {
        children.add(child);
    }

}
