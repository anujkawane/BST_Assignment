package com.akawane0813;

import com.akawane0813.model.Student;
import com.akawane0813.strategyPattern.GpaOrderByAscendingStrategy;
import com.akawane0813.strategyPattern.NameOrderByAscendingStrategy;
import com.akawane0813.strategyPattern.NameOrderByDescendingStrategy;
import com.akawane0813.visitorPattern.NullNodeCountVisitor;
import com.akawane0813.visitorPattern.TreePathVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<Student> testData = Arrays.asList(
                new Student(825890105, "George", "Jones", 3.59),
                new Student(825890103, "Susan", "Smith", 3.67),
                new Student(825890102, "Kevin", "Williams",3.23),
                new Student(825890104, "Anthony", "Harris",2.49),
                new Student(825890101, "AnIan", "Vazquezuj",3.99),
                new Student(825890106, "Kristy", "Williams",4.0),
                new Student(825890107, "Katherine", "Hurst",3.08),
                new Student(825890108, "Stacey", "Gordon",2.79),
                new Student(825890109, "Catherine", "Green",4.0),
                new Student(825890110, "Jessica", "Martin",3.99)
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

        List<Integer> l = new ArrayList<>();

    }
}
