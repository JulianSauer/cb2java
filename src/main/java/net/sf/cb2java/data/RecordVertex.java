package net.sf.cb2java.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents copybook data types
 */ 
public class RecordVertex {

    private String name;

    private Object value;

    private List<RecordVertex> children;

    public RecordVertex() {
        this.name = "";
        this.children = new ArrayList<>(0);
    }

    public RecordVertex(String name, Object value, List<RecordVertex> children) {
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

    public List<RecordVertex> getChildren() {
        return children;
    }

    public void setChildren(List<RecordVertex> children) {
        this.children = children;
    }

    public void addChild(RecordVertex child) {
        children.add(child);
    }

}
