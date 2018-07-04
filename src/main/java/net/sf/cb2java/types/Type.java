package net.sf.cb2java.types;

public enum Type {
    ALPHA_NUMERIC,
    BINARY,
    CHARACTERS,
    DECIMAL,
    FLOATING,
    NUMERIC,
    PACKED,
    SIGNED_SEPARATE;

    private int length;

    Type() {
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}