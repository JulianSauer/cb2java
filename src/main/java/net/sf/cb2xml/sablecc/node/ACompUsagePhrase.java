/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class ACompUsagePhrase extends PUsagePhrase {
    private TComp _comp_;

    public ACompUsagePhrase() {
    }

    public ACompUsagePhrase(TComp _comp_) {
        setComp(_comp_);
    }

    public Object clone() {
        return new ACompUsagePhrase((TComp) cloneNode(_comp_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseACompUsagePhrase(this);
    }

    public TComp getComp() {
        return _comp_;
    }

    public void setComp(TComp node) {
        if (_comp_ != null) {
            _comp_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _comp_ = node;
    }

    public String toString() {
        return "" + toString(_comp_);
    }

    void removeChild(Node child) {
        if (_comp_ == child) {
            _comp_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_comp_ == oldChild) {
            setComp((TComp) newChild);

            return;
        }
    }
}
