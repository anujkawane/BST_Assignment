package com.akawane0813;

import com.akawane0813.model.INode;

import java.util.*;
import java.util.function.Consumer;

public final class BST<T extends Comparable<T>> extends TreeSet<T> {

    private INode root;
    private int size;
    private Comparator<? super T> comparator;

    public BST() {
        this.comparator = null;
    }



    public BST(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void addAllEle(Iterable<T> elements) {
        if (null == elements) throw new NullPointerException();

        Iterator<T> itr = elements.iterator();
        while (itr.hasNext()) {
            T elem = itr.next();
            if (null != elem) add(elem);
        }
    }

    int compare(Object e1, Object e2) {
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
        root = null;
        size = 0;
    }

    public boolean add(T element) {
        if (null == element) throw new NullPointerException();

        INode parent = null;
        INode current = root;
        while (null != current) {
            int comparison = compare(element, current.getElement());
            parent = current;
            if (0 > comparison) {
                current = current.getLeft();
            }
            else if (0 < comparison) {
                current = current.getRight();
            }
            else {
                current = current.getLeft();
            }
        }

        if (null == parent) {
            INode rootNode = new Node(element);
            root = rootNode;
        }
        else if (0 > compare(element, parent.getElement())) {
            INode leftNode = new Node(element);
            parent.setLeft(leftNode);
        }
        else {
            INode rightNode = new Node(element);
            parent.setRight(rightNode);
        }
        ++size;
        return true;
    }

    @Override
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

    public List<T> preorder() {
        List<T> result = new ArrayList<>(size);
        preorder(result, root);
        return result;
    }

    private void preorder(List<T> result, INode current) {
        if (null == current) return;

        result.add((T) current.getElement());
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
    

    private class Node implements INode<T> {
        private T element;
        private INode left;
        private INode right;

        public Node(T element) {
            this.element = element;
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
    }

    private class NullNode implements INode<T> {
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
    }
}