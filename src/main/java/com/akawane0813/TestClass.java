package com.akawane0813;

import com.akawane0813.strategyPattern.NameDescendingOrderingStrategy;

import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {

        List<Student> testData = Arrays.asList(
                new Student(104, "Anuj", "Kawane", 4.0),
                new Student(103, "Anuj", "Kawane", 4.0),
                new Student(102, "Kshitij", "Poojary",4.1),
                new Student(101, "Shriraj", "Jahagridar",4.099)
        );

        BST<Student> bst = new BST<>(new NameDescendingOrderingStrategy().sort());
        for(Student s : testData){
            bst.add(s);
        }
        bst.forEach(System.out::println);
    }
}
