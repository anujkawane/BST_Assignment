package com.akawane0813;

import com.akawane0813.model.INode;
import com.akawane0813.strategyPattern.GpaOrderByDescendingStrategy;
import com.akawane0813.visitorPattern.TreePathLengthVisitor;
import com.akawane0813.visitorPattern.Visitor;
import com.akawane0813.visitorPattern.NullNodeCountVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        List<Student> testData = Arrays.asList(
                new Student(500, "Anuj", "Kawane", 4.0),
                new Student(300, "Anuk", "Kawane", 4.0),
                new Student(600, "Kshitij", "Poojary",4.1),
                new Student(700, "Kshitij", "Poojary",4.1),
                new Student(200, "Kshitij", "Poojary",4.1),
                new Student(400, "Kshitij", "Poojary",4.1),
                new Student(350, "Kshitij", "Poojary",4.1),
                new Student(375, "Kshitij", "Poojary",4.1),
                new Student(360, "Kshitij", "Poojary",4.1),
                new Student(365, "Shriraj", "Jahagridar",4.099)
        );

        BST<Student> bst = new BST<>(new GpaOrderByDescendingStrategy().order());
        Visitor nullNodeCountVisitor = new NullNodeCountVisitor();
        Visitor treePathLengthVisitor = new TreePathLengthVisitor();
        bst.addAll(testData);
        bst.forEach(System.out::println);
        List<INode> list = bst.preorder();
        list.stream().forEach((element) -> element.accept(nullNodeCountVisitor));
        list.stream().forEach((element) -> element.accept(treePathLengthVisitor));

//        List<Integer> result = new ArrayList<>();
//        for(INode e : list){
//            if(e.accept(treePathLengthVisitor) != -1){
//                result.add(e.accept(treePathLengthVisitor));
//            }
//        }
//        double sum = 0;
//        for(Integer n : result){
//            sum+=n;
//        }
//        System.out.println(result);

        System.out.println(NullNodeCountVisitor.getCountNullNode());
        System.out.println(NullNodeCountVisitor.getCountActualNode());
        System.out.println(TreePathLengthVisitor.getMaximumPathLength());

    }
}
