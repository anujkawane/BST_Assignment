package com.akawane0813.visitorPattern;
import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.INode;

import java.util.*;

/**
 * Visitor pattern to separate algorithms from BST implementation for computing maximum path (root to leaf)
 * and average path length in given binary search tree.
 */
public class TreePathVisitor implements Visitor {

    private Map<INode, Integer> mapNodesDepth, leafCount;
    private List<Integer> result;
    private INode current;

    public TreePathVisitor() {
        this.mapNodesDepth = new HashMap<>();
        this.leafCount = new HashMap<>();
        this.result = new ArrayList<>();
    }

    /**
     * Traverse through binary search tree and keep mapping of node and its depth from root.
     * @param node current node of type Node
     */
    @Override
    public void visit(BinarySearchTree.Node node) {
        if(!mapNodesDepth.containsKey(node)){
            mapNodesDepth.put(node, 0);
        }
        current = node;
        leafCount.put(current, 0);
        mapNodesDepth.put(node.getLeft(), mapNodesDepth.get(node) + 1);
        mapNodesDepth.put(node.getRight(), mapNodesDepth.get(node) + 1);
        node.getLeft().accept(this);
        current = node;
        node.getRight().accept(this);
    }

    /**
     * Keep mapping of leaf nodes and their depths from root.
     * @param node current node of type Node
     */
    @Override
    public void visit(BinarySearchTree.NullNode node) {
        if(current == null) return;

        leafCount.put(current, leafCount.get(current) + 1);
    }

    /**
     * Returns the maximum path length of given binary search tree.
     * @return maximum path length (root -> leaf) in tree.
     */
    public int getMaximumPathLength() {
        List<INode> leafNodes = getLeafNodes();

        for(INode node : leafNodes){
            result.add(mapNodesDepth.get(node));
        }
        return (result.isEmpty()) ? 0 : Collections.max(result);
    }

    /**
     * Returns the average path length of given binary search tree.
     * average path length = sum of all path lengths from root to leaf / number of paths
     * @return average path length (root -> leaf).
     */
    public Double getAveragePathLength() {
        List<INode> leafNodes = getLeafNodes();
        int sum  = 0;
        for(INode node : leafNodes){
            sum += mapNodesDepth.get(node);
        }
        return (leafNodes.isEmpty()) ? 0.0 : Double.valueOf(sum) / leafNodes.size();
    }

    /**
     * Return List of leaf nodes in given tree
     * @return List of leaf nodes
     */
    private List<INode> getLeafNodes() {
        List<INode> leafNodes = new ArrayList<>();
        leafCount.entrySet().forEach(entry -> {
            if(entry.getValue() >= 2){
                leafNodes.add(entry.getKey());
            }
        });
        return leafNodes;
    }
}
