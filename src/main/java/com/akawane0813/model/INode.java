package com.akawane0813.model;

public interface INode<T>{

    T getElement();
    void setElement(T element);
    INode getLeft();
    void setLeft(INode left);
    INode getRight();
    void setRight(INode right);

}
