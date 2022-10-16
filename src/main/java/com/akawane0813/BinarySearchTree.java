package com.akawane0813;

import com.akawane0813.model.INode;
import com.akawane0813.visitorPattern.Visitor;

import java.util.*;
import java.util.function.Consumer;

public final class BinarySearchTree<T extends Comparable<T>> {

    private INode root;

    private int size;
    private Comparator<? super T> comparator;

    public BinarySearchTree() {
        this.comparator = null;
    }

    public BinarySearchTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void addAll(Iterable<T> elements) {
        if (null == elements) throw new NullPointerException();

        Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (null != element) add(element);
        }
    }

    public int compare(Object e1, Object e2) {
        return comparator == null ? ((Comparable<? super T>) e1).compareTo((T) e2)
                : comparator.compare((T) e1, (T) e2);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public void clear() {
        root = new NullNode();
        size = 0;
    }

    public boolean add(T element) {
        if(isEmpty()){
            root = new Node(element);
        }else{
            INode newNode = new Node(element);
            root.add(root, newNode);
        }
        size++;
        return true;
    }

    public boolean contains(T element){
        if(isEmpty()) return false;

        return root.isElement(element);
    }

    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        List<T> list = getSortedNodes();
        for (T e : list) {
            action.accept(e);
        }
    }

    public List<T> getSortedNodes() {
        List<T> result = new ArrayList<>(size);
        getSortedNodes(result, root);
        return result;
    }

    private void getSortedNodes(List<T> result, INode current) {
        if(isEmpty()) return;

        current.addNode(result);
    }

    public INode getRoot() {
        return root;
    }

    public class Node<T extends Comparable<T>> implements INode<T> {
        private T element;
        private INode left;
        private INode right;

        public Node(T element) {
            this.element = element;
            this.left = new NullNode();
            this.right = new NullNode();
        }

        @Override
        public T getElement() {
            return this.element;
        }

        @Override
        public void setElement(T element) {
            this.element = element;
        }

        @Override
        public INode getLeft() {
            return this.left;
        }

        @Override
        public void setLeft(INode left) {
            this.left = left;
        }

        @Override
        public INode getRight() {
            return this.right;
        }

        @Override
        public void setRight(INode right) {
            this.right = right;
        }

        @Override
        public boolean add(INode parent, INode newNode) {
            int comparison = compare(this.element, newNode.getElement());
            if(comparison < 0){
                this.getRight().add(this, newNode);
            }else {
                this.getLeft().add(this, newNode);
            }
            return true;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override
        public boolean isElement(T element) {
            if(compare(this.getElement(), element) == 0)
                return true;
            else if(compare(this.getElement(), element) > 0){
                return this.getLeft().isElement(element);
            }else{
                return this.getRight().isElement(element);
            }
        }

        public void addNode(List<T> result){
            this.getLeft().addNode(result);
            result.add(this.getElement());
            this.getRight().addNode(result);
            return;
        }
    }

    public class NullNode implements INode<T> {
        private T element;

        public NullNode() {

        }

        @Override
        public T getElement() {
            return null;
        }

        @Override
        public void setElement(T element) {

        }

        @Override
        public INode getLeft() {
            return null;
        }

        @Override
        public void setLeft(INode left) {

        }

        @Override
        public INode getRight() {
            return null;
        }

        @Override
        public void setRight(INode right) {

        }

        @Override
        public boolean add(INode parent, INode newNode) {
            int comparison = compare(parent.getElement(), newNode.getElement());
            if(comparison < 0){
                parent.setRight(newNode);
            }else{
                parent.setLeft(newNode);
            }
            return true;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override
        public boolean isElement(T element) {
            return false;
        }

        public void addNode(List<T> result){
            return;
        }
    }
}