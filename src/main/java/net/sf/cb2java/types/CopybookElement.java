package net.sf.cb2java.types;

import java.util.ArrayList;
import java.util.List;

public class CopybookElement {

    private final String name;
    private final int level;
    private Type type;
    private List<CopybookElement> children;

    public CopybookElement(String name, int level) {
        this.name = name;
        this.level = level;
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
        if (type == null)
            return 0;
        return type.getLength();
    }

    public void setLength(int length) {
        if (type != null)
        type.setLength(length);
    }

    public List<CopybookElement> getChildren() {
        return children;
    }

    public void addChild(CopybookElement child) {
        children.add(child);
    }

}
