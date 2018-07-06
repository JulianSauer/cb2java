/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class APictureClause extends PPictureClause {
    private TPicture _picture_;
    private TIs _is_;
    private PCharacterString _characterString_;

    public APictureClause() {
    }

    public APictureClause(TPicture _picture_, TIs _is_,
                          PCharacterString _characterString_) {
        setPicture(_picture_);

        setIs(_is_);

        setCharacterString(_characterString_);
    }

    public Object clone() {
        return new APictureClause((TPicture) cloneNode(_picture_),
                (TIs) cloneNode(_is_),
                (PCharacterString) cloneNode(_characterString_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAPictureClause(this);
    }

    public TPicture getPicture() {
        return _picture_;
    }

    public void setPicture(TPicture node) {
        if (_picture_ != null) {
            _picture_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _picture_ = node;
    }

    public TIs getIs() {
        return _is_;
    }

    public void setIs(TIs node) {
        if (_is_ != null) {
            _is_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _is_ = node;
    }

    public PCharacterString getCharacterString() {
        return _characterString_;
    }

    public void setCharacterString(PCharacterString node) {
        if (_characterString_ != null) {
            _characterString_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _characterString_ = node;
    }

    public String toString() {
        return "" + toString(_picture_) + toString(_is_) +
                toString(_characterString_);
    }

    void removeChild(Node child) {
        if (_picture_ == child) {
            _picture_ = null;

            return;
        }

        if (_is_ == child) {
            _is_ = null;

            return;
        }

        if (_characterString_ == child) {
            _characterString_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_picture_ == oldChild) {
            setPicture((TPicture) newChild);

            return;
        }

        if (_is_ == oldChild) {
            setIs((TIs) newChild);

            return;
        }

        if (_characterString_ == oldChild) {
            setCharacterString((PCharacterString) newChild);

            return;
        }
    }
}
