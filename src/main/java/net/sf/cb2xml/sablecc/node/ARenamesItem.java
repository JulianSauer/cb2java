/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class ARenamesItem extends PRenamesItem {
    private TNumberNot88 _numberNot88_;
    private TDataName _renameTo_;
    private TRenames _renames_;
    private TDataName _renameFrom_;
    private PThroughPhrase _throughPhrase_;

    public ARenamesItem() {
    }

    public ARenamesItem(TNumberNot88 _numberNot88_, TDataName _renameTo_,
                        TRenames _renames_, TDataName _renameFrom_,
                        PThroughPhrase _throughPhrase_) {
        setNumberNot88(_numberNot88_);

        setRenameTo(_renameTo_);

        setRenames(_renames_);

        setRenameFrom(_renameFrom_);

        setThroughPhrase(_throughPhrase_);
    }

    public Object clone() {
        return new ARenamesItem((TNumberNot88) cloneNode(_numberNot88_),
                (TDataName) cloneNode(_renameTo_),
                (TRenames) cloneNode(_renames_),
                (TDataName) cloneNode(_renameFrom_),
                (PThroughPhrase) cloneNode(_throughPhrase_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseARenamesItem(this);
    }

    public TNumberNot88 getNumberNot88() {
        return _numberNot88_;
    }

    public void setNumberNot88(TNumberNot88 node) {
        if (_numberNot88_ != null) {
            _numberNot88_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _numberNot88_ = node;
    }

    public TDataName getRenameTo() {
        return _renameTo_;
    }

    public void setRenameTo(TDataName node) {
        if (_renameTo_ != null) {
            _renameTo_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _renameTo_ = node;
    }

    public TRenames getRenames() {
        return _renames_;
    }

    public void setRenames(TRenames node) {
        if (_renames_ != null) {
            _renames_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _renames_ = node;
    }

    public TDataName getRenameFrom() {
        return _renameFrom_;
    }

    public void setRenameFrom(TDataName node) {
        if (_renameFrom_ != null) {
            _renameFrom_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _renameFrom_ = node;
    }

    public PThroughPhrase getThroughPhrase() {
        return _throughPhrase_;
    }

    public void setThroughPhrase(PThroughPhrase node) {
        if (_throughPhrase_ != null) {
            _throughPhrase_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _throughPhrase_ = node;
    }

    public String toString() {
        return "" + toString(_numberNot88_) + toString(_renameTo_) +
                toString(_renames_) + toString(_renameFrom_) +
                toString(_throughPhrase_);
    }

    void removeChild(Node child) {
        if (_numberNot88_ == child) {
            _numberNot88_ = null;

            return;
        }

        if (_renameTo_ == child) {
            _renameTo_ = null;

            return;
        }

        if (_renames_ == child) {
            _renames_ = null;

            return;
        }

        if (_renameFrom_ == child) {
            _renameFrom_ = null;

            return;
        }

        if (_throughPhrase_ == child) {
            _throughPhrase_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_numberNot88_ == oldChild) {
            setNumberNot88((TNumberNot88) newChild);

            return;
        }

        if (_renameTo_ == oldChild) {
            setRenameTo((TDataName) newChild);

            return;
        }

        if (_renames_ == oldChild) {
            setRenames((TRenames) newChild);

            return;
        }

        if (_renameFrom_ == oldChild) {
            setRenameFrom((TDataName) newChild);

            return;
        }

        if (_throughPhrase_ == oldChild) {
            setThroughPhrase((PThroughPhrase) newChild);

            return;
        }
    }
}
