package com.akawane0813;

import com.akawane0813.model.INode;
import com.akawane0813.visitorPattern.Visitor;

import java.util.*;
import java.util.function.Consumer;

/**
 * Binary search tree implementation with Null Object Pattern to avoid the null checks.
 * @param <T> the type of elements in this tree
 */
public final class BinarySearchTree<T extends Comparable<T>> {

    private INode root;
    private Comparator<? super T> comparator;
    private int size;

    /**
     * Initializes binary search tree with default order (Order by RedID)
     */
    public BinarySearchTree() {
        this.size = 0;
        this.root = new NullNode();
        this.comparator = null;
    }

    /**
     * Initializes binary search tree with provided strategy to order the tree nodes.
     * @param comparator strategy to order the tree
     */
    public BinarySearchTree(Comparator<? super T> comparator) {
        this.size = 0;
        this.root = new NullNode();
        this.comparator = comparator;
    }

    /**
     * Appends all of the elements in the specified collection to the tree ordered by given strategy of tree.
     * @param elements collection containing elements to be added to this list
     * @return true if this tree changed as a result of the call
     */
    public boolean addAll(Iterable<T> elements) {
        if (null == elements) throw new NullPointerException();

        Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (null != element) add(element);
        }
        return true;
    }

    private int compare(Object e1, Object e2) {
        return comparator == null ? ((Comparable<? super T>) e1).compareTo((T) e2)
                : comparator.compare((T) e1, (T) e2);
    }

    /**
     * Returns the number of elements contained in the binary search tree.
     * @return Number of elements in this tree
     */
    public int size() {
        return size;
    }

    /**
     * Check whether the binary search tree contains any elements.
     * @return True if tree contains no elements
     */
    public boolean isEmpty() {
        return 0 == size;
    }

    /**
     * Remove all elements from the binary search tree.
     */
    public void clear() {
        root = new NullNode();
        size = 0;
    }

    /**
     * Inserts an element into the binary search tree
     * @param element Object be inserted into the tree
     * @return true if element inserted
     */
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

    /**
     * Checks if the binary search tree contains provided element.
     * @param element Object to search
     * @return true if tree contains given element, false otherwise.
     */
    public boolean contains(T element){
        if(isEmpty()) return false;

        return root.isElement(element);
    }


    /**
     * Performs the given action for each element of the tree until all elements have been
     * processed.
     * @param action An action to perform on each element.
     */
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        root.apply(action);
    }

    /**
     * Returns inorder(left -> root -> right) list of the binary search tree.
     * @return List of inorder (Sorted) elements.
     */
    public List<T> inorder() {
        List<T> result = new ArrayList<>(size);
        inorder(result, root);
        return result;
    }

    /**
     * Appends node values to the resulting List.
     * @param result resulting list in which node values are added.
     * @param current node on which the add operation starts
     */
    private void inorder(List<T> result, INode current) {
        if(isEmpty()) return;

        current.addNode(result);
    }

    /**
     * Returns root of the binary search tree.
     * @return root of tree.
     */
    public INode getRoot() {
        return root;
    }

    /**
     *
     * @param <T> the type of element a Node contains
     */
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

        /**
         * Adds the newly created node to the left of current node if created node is smaller than current node,
         * set to right otherwise.
         * @param parent Parent node of current node
         * @param newNode newly created node to add in tree
         * @return true if added
         */
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

        /**
         * Compare the provided element with the current node. return true if equals,
         * otherwise pass the call to its left or right depending on the comparison
         * @param element Object to compare
         * @return true if provided element matches with the current node element.
         */
        @Override
        public boolean isElement(T element) {
            if(compare(this.getElement(), element) == 0){
                if(this.getElement().equals(element))
                    return true;
                return this.getLeft().isElement(element);
            } else if(compare(this.getElement(), element) > 0){
                return this.getLeft().isElement(element);
            }else{
                return this.getRight().isElement(element);
            }
        }

        /**
         * Perform given action on each node of tree in inorder format.
         * @param action An action to perform on each node
         */
        @Override
        public void apply(Consumer<? super T> action) {
            this.getLeft().apply(action);
            action.accept(this.element);
            this.getRight().apply(action);
        }

        public void addNode(List<T> result){
            this.getLeft().addNode(result);
            result.add(this.getElement());
            this.getRight().addNode(result);
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

        /**
         * Replace Null node with the actual newly created node of its parent depending on the comparison.
         * Append to left of new node is smaller than the parent node, right otherwise.
         * @param parent Parent node which replace its null node with newly created node
         * @param newNode newly created node which replaces null node
         * @return true if newly created node
         */
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

        @Override
        public void apply(Consumer<? super T> action) {

        }

        public void addNode(List<T> result){
            return;
        }
    }
}