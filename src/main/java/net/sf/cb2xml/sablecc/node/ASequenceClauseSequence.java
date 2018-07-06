/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;


public final class ASequenceClauseSequence extends PClauseSequence {
    private PClauseSequence _clauseSequence_;
    private PClause _clause_;

    public ASequenceClauseSequence() {
    }

    public ASequenceClauseSequence(PClauseSequence _clauseSequence_,
                                   PClause _clause_) {
        setClauseSequence(_clauseSequence_);

        setClause(_clause_);
    }

    public Object clone() {
        return new ASequenceClauseSequence((PClauseSequence) cloneNode(
                _clauseSequence_), (PClause) cloneNode(_clause_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseASequenceClauseSequence(this);
    }

    public PClauseSequence getClauseSequence() {
        return _clauseSequence_;
    }

    public void setClauseSequence(PClauseSequence node) {
        if (_clauseSequence_ != null) {
            _clauseSequence_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _clauseSequence_ = node;
    }

    public PClause getClause() {
        return _clause_;
    }

    public void setClause(PClause node) {
        if (_clause_ != null) {
            _clause_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _clause_ = node;
    }

    public String toString() {
        return "" + toString(_clauseSequence_) + toString(_clause_);
    }

    void removeChild(Node child) {
        if (_clauseSequence_ == child) {
            _clauseSequence_ = null;

            return;
        }

        if (_clause_ == child) {
            _clause_ = null;

            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_clauseSequence_ == oldChild) {
            setClauseSequence((PClauseSequence) newChild);

            return;
        }

        if (_clause_ == oldChild) {
            setClause((PClause) newChild);

            return;
        }
    }
}
