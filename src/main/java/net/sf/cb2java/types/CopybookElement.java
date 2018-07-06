package net.sf.cb2java.types;

import java.util.ArrayList;
import java.util.List;

public class CopybookElement {

    private String name;
    private final int level;
    private int length;
    private Type type;
    private List<CopybookElement> children;

    public CopybookElement(String name, int level, int length, Type type) {
        this.name = name;
        this.level = level;
        this.length = length;
        this.type = type;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<CopybookElement> getChildren() {
        return children;
    }

    public void addChild(CopybookElement child) {
        children.add(child);
    }

}
