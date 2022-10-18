package com.akawane0813.visitorPattern;

import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.INode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TreePathVisitor implements Visitor{

    HashMap<INode, Integer> map = new HashMap<>();
    HashMap<INode, Integer> leafCount = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    INode current = null;

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
        leafCount.put(current, leafCount.get(current) + 1);
        return;
    }

    public int getMaximumPathLength(){
        List<INode> leafNodes = getLeafNodes();

        for(INode node : leafNodes){
            result.add(map.get(node));
        }
        return Collections.max(result);
    }

    public Double getAveragePathLength(){
        List<INode> leafNodes = getLeafNodes();
        int sum  = 0;
        for(INode node : leafNodes){
            sum += map.get(node);
        }
        return Double.valueOf(sum) / leafNodes.size();
    }

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
