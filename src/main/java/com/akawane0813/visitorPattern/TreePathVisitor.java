package com.akawane0813.visitorPattern;
import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.INode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Visitor pattern to separate algorithms from BST implementation for computing maximum path (root to leaf)
 * and average path length in given binary search tree.
 */
public class TreePathVisitor implements Visitor{

    private HashMap<INode, Integer> map = new HashMap<>();
    private HashMap<INode, Integer> leafCount = new HashMap<>();
    private List<Integer> result = new ArrayList<>();
    private INode current = null;

    @Override
    public void visit(BinarySearchTree.Node node) {
        if(!map.containsKey(node)){
            map.put(node, 0);
        }
        current = node;
        leafCount.put(current, 0);
        map.put(node.getLeft(), map.get(node) + 1);
        map.put(node.getRight(), map.get(node) + 1);
        node.getLeft().accept(this);
        current = node;
        node.getRight().accept(this);
    }

    @Override
    public void visit(BinarySearchTree.NullNode node) {
        if(current == null) return;

        leafCount.put(current, leafCount.get(current) + 1);
    }

    /**
     * Returns the maximum path length of given binary search tree.
     * @return maximum path length (root -> leaf) in tree.
     */
    public int getMaximumPathLength(){
        List<INode> leafNodes = getLeafNodes();

        for(INode node : leafNodes){
            result.add(map.get(node));
        }
        return (result.isEmpty()) ? 0 : Collections.max(result);
    }

    /**
     * Returns the average path length of given binary search tree.
     * average path length = sum of all path lengths from root to leaf / number of paths
     * @return average path length (root -> leaf).
     */
    public Double getAveragePathLength(){
        List<INode> leafNodes = getLeafNodes();
        int sum  = 0;
        for(INode node : leafNodes){
            sum += map.get(node);
        }
        return (leafNodes.isEmpty()) ? 0.0 : Double.valueOf(sum) / leafNodes.size();
    }

    /**
     * Return List of leaf nodes in given tree
     * @return List of leaf nodes
     */
    private List<INode> getLeafNodes(){
        List<INode> leafNodes = new ArrayList<>();
        leafCount.entrySet().forEach(entry -> {
            if(entry.getValue() >= 2){
                leafNodes.add(entry.getKey());
            }
        });
        return leafNodes;
    }
}
