/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class TSlash extends Token {
    public TSlash() {
        super.setText("/");
    }

    public TSlash(int line, int pos) {
        super.setText("/");
        setLine(line);
        setPos(pos);
    }

    public Object clone() {
        return new TSlash(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTSlash(this);
    }

    public void setText(String text) {
        throw new RuntimeException("Cannot change TSlash text.");
    }
}
