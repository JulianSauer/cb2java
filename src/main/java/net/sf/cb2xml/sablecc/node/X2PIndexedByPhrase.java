/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

public final class X2PIndexedByPhrase extends XPIndexedByPhrase {
    private PIndexedByPhrase _pIndexedByPhrase_;

    public X2PIndexedByPhrase() {
    }

    public X2PIndexedByPhrase(PIndexedByPhrase _pIndexedByPhrase_) {
        setPIndexedByPhrase(_pIndexedByPhrase_);
    }

    public Object clone() {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw) {
        throw new RuntimeException("Switch not supported.");
    }

    public PIndexedByPhrase getPIndexedByPhrase() {
        return _pIndexedByPhrase_;
    }

    public void setPIndexedByPhrase(PIndexedByPhrase node) {
        if (_pIndexedByPhrase_ != null) {
            _pIndexedByPhrase_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pIndexedByPhrase_ = node;
    }

    void removeChild(Node child) {
        if (_pIndexedByPhrase_ == child) {
            _pIndexedByPhrase_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
    }

    public String toString() {
        return "" + toString(_pIndexedByPhrase_);
    }
}
