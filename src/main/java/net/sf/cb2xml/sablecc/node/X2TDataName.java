/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

public final class X2TDataName extends XTDataName {
    private TDataName _tDataName_;

    public X2TDataName() {
    }

    public X2TDataName(TDataName _tDataName_) {
        setTDataName(_tDataName_);
    }

    public Object clone() {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw) {
        throw new RuntimeException("Switch not supported.");
    }

    public TDataName getTDataName() {
        return _tDataName_;
    }

    public void setTDataName(TDataName node) {
        if (_tDataName_ != null) {
            _tDataName_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tDataName_ = node;
    }

    void removeChild(Node child) {
        if (_tDataName_ == child) {
            _tDataName_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
    }

    public String toString() {
        return "" + toString(_tDataName_);
    }
}
