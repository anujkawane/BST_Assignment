package com.akawane0813.visitorPattern;

import com.akawane0813.BinarySearchTree;

/**
 *  Visitor pattern to separate algorithms from BST implementation for checking number
 *  of null nodes in given binary search tree.
 */
public class NullNodeCountVisitor implements Visitor {

    private int nullNodeCount;

    public NullNodeCountVisitor() {
        this.nullNodeCount = 0;
    }

    /**
     * Traverse tree actual node and pass call to its left and right
     * @param node current node of type Node
     */
    @Override
    public void visit(BinarySearchTree.Node node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    /**
     * Count number of Null nodes in tree by visiting this method.
     * Increment count if Null node occurs in traversal
     * @param node current node of type Null Node
     */
    @Override
    public void visit(BinarySearchTree.NullNode node) {
        nullNodeCount++;
    }

    /**
     * Return count of null nodes present in binary search tree
     * @return count of null nodes
     */
    public int getNullNodeCount() {
        return nullNodeCount;
    }

}
