package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;

import java.util.Comparator;

public class RedIdOrderByDescendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> order() {
        return Comparator.comparing(Student::getRedId).reversed();
    }
}
