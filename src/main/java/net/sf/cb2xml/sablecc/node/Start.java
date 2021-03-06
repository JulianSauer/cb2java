/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class Start extends Node {
    private PRecordDescription _pRecordDescription_;
    private EOF _eof_;

    public Start() {
    }

    public Start(PRecordDescription _pRecordDescription_, EOF _eof_) {
        setPRecordDescription(_pRecordDescription_);
        setEOF(_eof_);
    }

    public Object clone() {
        return new Start((PRecordDescription) cloneNode(_pRecordDescription_),
                (EOF) cloneNode(_eof_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseStart(this);
    }

    public PRecordDescription getPRecordDescription() {
        return _pRecordDescription_;
    }

    public void setPRecordDescription(PRecordDescription node) {
        if (_pRecordDescription_ != null) {
            _pRecordDescription_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pRecordDescription_ = node;
    }

    public EOF getEOF() {
        return _eof_;
    }

    public void setEOF(EOF node) {
        if (_eof_ != null) {
            _eof_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _eof_ = node;
    }

    void removeChild(Node child) {
        if (_pRecordDescription_ == child) {
            _pRecordDescription_ = null;

            return;
        }

        if (_eof_ == child) {
            _eof_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_pRecordDescription_ == oldChild) {
            setPRecordDescription((PRecordDescription) newChild);

            return;
        }

        if (_eof_ == oldChild) {
            setEOF((EOF) newChild);

            return;
        }
    }

    public String toString() {
        return "" + toString(_pRecordDescription_) + toString(_eof_);
    }
}
