package com.akawane0813.model;

import com.akawane0813.visitorPattern.Visitor;
import java.util.List;

public interface INode<T extends Comparable<T>>{

    T getElement();
    void setElement(T element);
    INode getLeft();
    void setLeft(INode left);
    INode getRight();
    void setRight(INode right);
    boolean add(INode parent, INode newNode);
    void addNode(List<T> result);
    void accept(Visitor visitor);
    boolean isElement(T element);

}
