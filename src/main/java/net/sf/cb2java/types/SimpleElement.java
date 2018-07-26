package net.sf.cb2java.types;

import java.util.List;

public interface SimpleElement<T extends SimpleElement> {

    /**
     * Returns the name of this element
     *
     * @return Name of this element
     */
    String getName();

    /**
     * Returns the level of this element
     *
     * @return Level of this element
     */
    int getLevel();

    Type getType();

    /**
     * Returns the number of times this item appears in data
     *
     * @return Number of times this item appears in data
     */
    int getOccurs();

    /**
     * Returns the number of bytes of one instance of this element
     *
     * @return Number of bytes of one instance of this element
     */
    int getLength();

    /**
     * Gets the children of this element or null if there are none
     *
     * @return Children of this element or null if there are none
     */
    List<T> getChildren();
}
