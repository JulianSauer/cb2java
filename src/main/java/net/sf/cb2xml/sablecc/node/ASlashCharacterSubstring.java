/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class ASlashCharacterSubstring extends PCharacterSubstring {
    private TSlash _slash_;

    public ASlashCharacterSubstring() {
    }

    public ASlashCharacterSubstring(TSlash _slash_) {
        setSlash(_slash_);
    }

    public Object clone() {
        return new ASlashCharacterSubstring((TSlash) cloneNode(_slash_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseASlashCharacterSubstring(this);
    }

    public TSlash getSlash() {
        return _slash_;
    }

    public void setSlash(TSlash node) {
        if (_slash_ != null) {
            _slash_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _slash_ = node;
    }

    public String toString() {
        return "" + toString(_slash_);
    }

    void removeChild(Node child) {
        if (_slash_ == child) {
            _slash_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_slash_ == oldChild) {
            setSlash((TSlash) newChild);

            return;
        }
    }
}
