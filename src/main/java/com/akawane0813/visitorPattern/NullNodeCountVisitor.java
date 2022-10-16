package com.akawane0813.visitorPattern;

import com.akawane0813.BinarySearchTree;

public class NullNodeCountVisitor implements Visitor {

    static int countNullNode = 0;

    @Override
    public void visit(BinarySearchTree.Node node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    @Override
    public void visit(BinarySearchTree.NullNode node) {
        countNullNode++;
        return;
    }

    public static int getCountNullNode() {
        return countNullNode;
    }

}
