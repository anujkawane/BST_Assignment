package com.akawane0813;

import com.akawane0813.model.INode;
import com.akawane0813.visitorPattern.Visitor;

import java.util.*;
import java.util.function.Consumer;

public final class BST<T extends Comparable<T>> {

    private INode root;
    private int size;
    private Comparator<? super T> comparator;

    public BST() {
        this.comparator = null;
    }

    public BST(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void addAll(Iterable<T> elements) {
        if (null == elements) throw new NullPointerException();

        Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            T elemement = iterator.next();
            if (null != elemement) add(elemement);
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

    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        List<T> list = inorder();
        for (T e : list) {
            action.accept(e);
        }
    }

    public List<T> inorder() {
        List<T> result = new ArrayList<>(size);
        inorder(result, root);
        return result;
    }

    private void inorder(List<T> result, INode current) {
        if (null == current) return;

        inorder(result, current.getLeft());
        result.add((T) current.getElement());
        inorder(result, current.getRight());
    }

    public String toStringInorder() {
        StringBuilder sb = new StringBuilder("[");
        toStringInorder(sb, root);
        return sb.append("]").toString();
    }


    private void toStringInorder(StringBuilder sb, INode current) {
        if (null == current) return;

        toStringInorder(sb, current.getLeft());
        if (1 < sb.length()) sb.append(", ");
        sb.append(current.getElement());
        toStringInorder(sb, current.getRight());
    }

    public List<INode> preorder() {
        List<INode> result = new ArrayList<>(size);
        preorder(result, root);
        return result;
    }

    private void preorder(List<INode> result, INode current) {
        if (null == current) return;

        result.add(current);
        preorder(result, current.getLeft());
        preorder(result, current.getRight());
    }

    public List<T> postorder() {
        List<T> result = new ArrayList<>(size);
        postorder(result, root);
        return result;
    }

    private void postorder(List<T> result, INode current) {
        if (null == current) return;

        postorder(result, current.getLeft());
        postorder(result, current.getRight());
        result.add((T) current.getElement());
    }

    @Override
    public String toString() {
        return toStringInorder();
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
        public int accept(Visitor visitor) {
            return visitor.visit(this);
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
        public int accept(Visitor visitor) {
             return visitor.visit(this);
        }
    }
}