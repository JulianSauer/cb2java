/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class AComp3UsagePhrase extends PUsagePhrase {
    private TComp3 _comp3_;

    public AComp3UsagePhrase() {
    }

    public AComp3UsagePhrase(TComp3 _comp3_) {
        setComp3(_comp3_);
    }

    public Object clone() {
        return new AComp3UsagePhrase((TComp3) cloneNode(_comp3_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAComp3UsagePhrase(this);
    }

    public TComp3 getComp3() {
        return _comp3_;
    }

    public void setComp3(TComp3 node) {
        if (_comp3_ != null) {
            _comp3_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _comp3_ = node;
    }

    public String toString() {
        return "" + toString(_comp3_);
    }

    void removeChild(Node child) {
        if (_comp3_ == child) {
            _comp3_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_comp3_ == oldChild) {
            setComp3((TComp3) newChild);

            return;
        }
    }
}
