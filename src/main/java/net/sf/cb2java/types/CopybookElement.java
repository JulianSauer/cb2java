package net.sf.cb2java.types;

import java.util.ArrayList;
import java.util.List;

public class CopybookElement {

    private final String name;
    private final int level;
    private Type type;
    private int length;
    private List<CopybookElement> children;

    public CopybookElement(String name, int level) {
        this.name = name;
        this.level = level;
        length = 0;
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
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
