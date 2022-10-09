package com.akawane0813;

import java.util.*;
import java.util.function.Consumer;

public final class BST<T extends Comparable<T>> extends TreeSet<T> {

    private Node root;
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

        Node parent = null;
        Node current = root;
        while (null != current) {
            int cmp = compare(element, current.getValue());
            if (0 > cmp) {
                parent = current;
                current = current.getLeft();
            }
            else if (0 < cmp) {
                parent = current;
                current = current.getRight();
            }
            else {
                return false; // ignoring Duplicate
            }
        }

        if (null == parent) {
            root = new Node(element);
        }
        else if (0 > compare(element, parent.getValue())) {
            parent.setLeft(new Node(element));
        }
        else {
            parent.setRight(new Node(element));
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

    private void inorder(List<T> result, Node current) {
        if (null == current) return;

        inorder(result, current.getLeft());
        result.add(current.getValue());
        inorder(result, current.getRight());
    }

    public String toStringInorder() {
        StringBuilder sb = new StringBuilder("[");
        toStringInorder(sb, root);
        return sb.append("]").toString();
    }


    private void toStringInorder(StringBuilder sb, Node current) {
        if (null == current) return;

        toStringInorder(sb, current.getLeft());
        if (1 < sb.length()) sb.append(", ");
        sb.append(current.getValue());
        toStringInorder(sb, current.getRight());
    }

    public List<T> preorder() {
        List<T> result = new ArrayList<>(size);
        preorder(result, root);
        return result;
    }

    private void preorder(List<T> result, Node current) {
        if (null == current) return;

        result.add(current.getValue());
        preorder(result, current.getLeft());
        preorder(result, current.getRight());
    }

    public List<T> postorder() {
        List<T> result = new ArrayList<>(size);
        postorder(result, root);
        return result;
    }

    private void postorder(List<T> result, Node current) {
        if (null == current) return;

        postorder(result, current.getLeft());
        postorder(result, current.getRight());
        result.add(current.getValue());
    }

    @Override
    public String toString() {
        return toStringInorder();
    }
    

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
        }
    }
}