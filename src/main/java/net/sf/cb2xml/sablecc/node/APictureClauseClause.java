/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class APictureClauseClause extends PClause {
    private PPictureClause _pictureClause_;

    public APictureClauseClause() {
    }

    public APictureClauseClause(PPictureClause _pictureClause_) {
        setPictureClause(_pictureClause_);
    }

    public Object clone() {
        return new APictureClauseClause((PPictureClause) cloneNode(
                _pictureClause_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAPictureClauseClause(this);
    }

    public PPictureClause getPictureClause() {
        return _pictureClause_;
    }

    public void setPictureClause(PPictureClause node) {
        if (_pictureClause_ != null) {
            _pictureClause_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pictureClause_ = node;
    }

    public String toString() {
        return "" + toString(_pictureClause_);
    }

    void removeChild(Node child) {
        if (_pictureClause_ == child) {
            _pictureClause_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_pictureClause_ == oldChild) {
            setPictureClause((PPictureClause) newChild);

            return;
        }
    }
}
