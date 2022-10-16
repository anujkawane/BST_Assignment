package com.akawane0813;

import com.akawane0813.model.Student;
import com.akawane0813.visitorPattern.NullNodeCountVisitor;
import com.akawane0813.visitorPattern.TreePathVisitor;

import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        List<Student> testData = Arrays.asList(
                new Student(700, "Dhiraj", "Deshmukh", 2.2),
                new Student(500, "Abhishek", "Ranjan", 3.0),
                new Student(300, "Javed", "Khan",4.1),
                new Student(600, "Shriraj", "Jahagirdar",4.1),
                new Student(200, "Anuj", "Kawane",4.1),
                new Student(400, "Kshitij", "Poojary",1.1),
                new Student(350, "Bhuvan", "Bharadwaj",4.1),
                new Student(375, "Roshan", "Basu",4.1),
                new Student(360, "Deven", "Joshi",4.1),
                new Student(365, "Saurabh", "Kulkarni",4.099)
        );

        BinarySearchTree<Student> binarySearchTree = new BinarySearchTree<>();
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
