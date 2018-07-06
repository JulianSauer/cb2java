/* This file was generated by SableCC (http://www.sablecc.org/). */
package net.sf.cb2xml.sablecc.node;

import net.sf.cb2xml.sablecc.analysis.Analysis;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public final class AOccursClause extends POccursClause {
    private POccursFixedOrVariable _occursFixedOrVariable_;
    private final LinkedList _ascendingOrDescendingKeyPhrase_ = new TypedLinkedList(new AscendingOrDescendingKeyPhrase_Cast());
    private final LinkedList _indexedByPhrase_ = new TypedLinkedList(new IndexedByPhrase_Cast());

    public AOccursClause() {
    }

    public AOccursClause(POccursFixedOrVariable _occursFixedOrVariable_,
                         List _ascendingOrDescendingKeyPhrase_, List _indexedByPhrase_) {
        setOccursFixedOrVariable(_occursFixedOrVariable_);
        this._ascendingOrDescendingKeyPhrase_.clear();
        this._ascendingOrDescendingKeyPhrase_.addAll(_ascendingOrDescendingKeyPhrase_);
        this._indexedByPhrase_.clear();
        this._indexedByPhrase_.addAll(_indexedByPhrase_);
    }

    public AOccursClause(POccursFixedOrVariable _occursFixedOrVariable_,
                         XPAscendingOrDescendingKeyPhrase _ascendingOrDescendingKeyPhrase_,
                         XPIndexedByPhrase _indexedByPhrase_) {
        setOccursFixedOrVariable(_occursFixedOrVariable_);

        if (_ascendingOrDescendingKeyPhrase_ != null) {
            while (_ascendingOrDescendingKeyPhrase_ instanceof X1PAscendingOrDescendingKeyPhrase) {
                this._ascendingOrDescendingKeyPhrase_.addFirst(((X1PAscendingOrDescendingKeyPhrase) _ascendingOrDescendingKeyPhrase_).getPAscendingOrDescendingKeyPhrase());
                _ascendingOrDescendingKeyPhrase_ = ((X1PAscendingOrDescendingKeyPhrase) _ascendingOrDescendingKeyPhrase_).getXPAscendingOrDescendingKeyPhrase();
            }

            this._ascendingOrDescendingKeyPhrase_.addFirst(((X2PAscendingOrDescendingKeyPhrase) _ascendingOrDescendingKeyPhrase_).getPAscendingOrDescendingKeyPhrase());
        }

        if (_indexedByPhrase_ != null) {
            while (_indexedByPhrase_ instanceof X1PIndexedByPhrase) {
                this._indexedByPhrase_.addFirst(((X1PIndexedByPhrase) _indexedByPhrase_).getPIndexedByPhrase());
                _indexedByPhrase_ = ((X1PIndexedByPhrase) _indexedByPhrase_).getXPIndexedByPhrase();
            }

            this._indexedByPhrase_.addFirst(((X2PIndexedByPhrase) _indexedByPhrase_).getPIndexedByPhrase());
        }
    }

    public Object clone() {
        return new AOccursClause((POccursFixedOrVariable) cloneNode(
                _occursFixedOrVariable_),
                cloneList(_ascendingOrDescendingKeyPhrase_),
                cloneList(_indexedByPhrase_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAOccursClause(this);
    }

    public POccursFixedOrVariable getOccursFixedOrVariable() {
        return _occursFixedOrVariable_;
    }

    public void setOccursFixedOrVariable(POccursFixedOrVariable node) {
        if (_occursFixedOrVariable_ != null) {
            _occursFixedOrVariable_.parent(null);
        }

        if (node != null) {
            if (node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _occursFixedOrVariable_ = node;
    }

    public LinkedList getAscendingOrDescendingKeyPhrase() {
        return _ascendingOrDescendingKeyPhrase_;
    }

    public void setAscendingOrDescendingKeyPhrase(List list) {
        _ascendingOrDescendingKeyPhrase_.clear();
        _ascendingOrDescendingKeyPhrase_.addAll(list);
    }

    public LinkedList getIndexedByPhrase() {
        return _indexedByPhrase_;
    }

    public void setIndexedByPhrase(List list) {
        _indexedByPhrase_.clear();
        _indexedByPhrase_.addAll(list);
    }

    public String toString() {
        return "" + toString(_occursFixedOrVariable_) +
                toString(_ascendingOrDescendingKeyPhrase_) +
                toString(_indexedByPhrase_);
    }

    void removeChild(Node child) {
        if (_occursFixedOrVariable_ == child) {
            _occursFixedOrVariable_ = null;

            return;
        }

        if (_ascendingOrDescendingKeyPhrase_.remove(child)) {
            return;
        }

        if (_indexedByPhrase_.remove(child)) {
            return;
        }
    }

    void replaceChild(Node oldChild, Node newChild) {
        if (_occursFixedOrVariable_ == oldChild) {
            setOccursFixedOrVariable((POccursFixedOrVariable) newChild);

            return;
        }

        for (ListIterator i = _ascendingOrDescendingKeyPhrase_.listIterator();
             i.hasNext(); ) {
            if (i.next() == oldChild) {
                if (newChild != null) {
                    i.set(newChild);
                    oldChild.parent(null);

                    return;
                }

                i.remove();
                oldChild.parent(null);

                return;
            }
        }

        for (ListIterator i = _indexedByPhrase_.listIterator(); i.hasNext(); ) {
            if (i.next() == oldChild) {
                if (newChild != null) {
                    i.set(newChild);
                    oldChild.parent(null);

                    return;
                }

                i.remove();
                oldChild.parent(null);

                return;
            }
        }
    }

    private class AscendingOrDescendingKeyPhrase_Cast implements Cast {
        public Object cast(Object o) {
            PAscendingOrDescendingKeyPhrase node = (PAscendingOrDescendingKeyPhrase) o;

            if ((node.parent() != null) &&
                    (node.parent() != AOccursClause.this)) {
                node.parent().removeChild(node);
            }

            if ((node.parent() == null) ||
                    (node.parent() != AOccursClause.this)) {
                node.parent(AOccursClause.this);
            }

            return node;
        }
    }

    private class IndexedByPhrase_Cast implements Cast {
        public Object cast(Object o) {
            PIndexedByPhrase node = (PIndexedByPhrase) o;

            if ((node.parent() != null) &&
                    (node.parent() != AOccursClause.this)) {
                node.parent().removeChild(node);
            }

            if ((node.parent() == null) ||
                    (node.parent() != AOccursClause.this)) {
                node.parent(AOccursClause.this);
            }

            return node;
        }
    }
}
