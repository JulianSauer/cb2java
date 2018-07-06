/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class TLparen extends Token {
    public TLparen() {
        super.setText("(");
    }

    public TLparen(int line, int pos) {
        super.setText("(");
        setLine(line);
        setPos(pos);
    }

    public Object clone() {
        return new TLparen(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTLparen(this);
    }

    public void setText(String text) {
        throw new RuntimeException("Cannot change TLparen text.");
    }
}
