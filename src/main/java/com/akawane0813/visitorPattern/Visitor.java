package com.akawane0813.visitorPattern;

import com.akawane0813.BinarySearchTree;

public interface Visitor {

    void visit(BinarySearchTree.Node node);

    void visit(BinarySearchTree.NullNode node);
}
