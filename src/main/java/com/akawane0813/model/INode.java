package com.akawane0813.model;

import com.akawane0813.visitorPattern.Visitor;

public interface INode<T extends Comparable<T>>{

    T getElement();
    void setElement(T element);
    INode getLeft();
    void setLeft(INode left);
    INode getRight();
    void setRight(INode right);
    boolean add(INode parent, INode newNode);

    int accept(Visitor visitor);

}
