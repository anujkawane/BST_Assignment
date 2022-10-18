package com.akawane0813.visitorPattern;

import com.akawane0813.BinarySearchTree;

/**
 *  Visitor pattern to separate algorithms from BST implementation for checking number
 *  of null nodes in given binary search tree.
 */
public class NullNodeCountVisitor implements Visitor {

    private int countNullNode = 0;

    @Override
    public void visit(BinarySearchTree.Node node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    @Override
    public void visit(BinarySearchTree.NullNode node) {
        countNullNode++;
    }

    /**
     * Return count of null nodes present in binary search tree
     * @return count of null nodes
     */
    public int getCountNullNode() {
        return countNullNode;
    }

}
