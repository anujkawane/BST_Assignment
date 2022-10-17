package com.akawane0813;

import com.akawane0813.model.Student;
import com.akawane0813.strategyPattern.GpaOrderByAscendingStrategy;
import com.akawane0813.visitorPattern.NullNodeCountVisitor;
import com.akawane0813.visitorPattern.TreePathVisitor;

import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        List<Student> testData = Arrays.asList(
                new Student(700, "Dhiraj", "Deshmukh", 3.49),
                new Student(500, "Abhishek", "Ranjan", 3.67),
                new Student(300, "Javed", "Khan",3.68),
                new Student(600, "Shriraj", "Jahagirdar",3.1),
                new Student(200, "Anuj", "Kawane",3.7),
                new Student(400, "Kshitij", "Poojary",3.8),
                new Student(350, "Bhuvan", "Bharadwaj",3.65),
                new Student(375, "Roshan", "Basu",3.61),
                new Student(360, "Deven", "Joshi",3.8),
                new Student(365, "Saurabh", "Kulkarni",3.9)
        );

        BinarySearchTree<Student> binarySearchTree = new BinarySearchTree<>(new GpaOrderByAscendingStrategy().order());
        binarySearchTree.addAll(testData);
        binarySearchTree.forEach(System.out::println);

        NullNodeCountVisitor nullNodeCountVisitor = new NullNodeCountVisitor();
        binarySearchTree.getRoot().accept(nullNodeCountVisitor);
        System.out.println(NullNodeCountVisitor.getCountNullNode());

        TreePathVisitor treePathVisitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(treePathVisitor);
        System.out.println(treePathVisitor.getAveragePathLength());
        System.out.println(treePathVisitor.getMaximumPathLength());

    }
}
