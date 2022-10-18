package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;

import java.util.Comparator;

/**
 * Descending order strategy to order tree by the RedID.
 */
public class RedIdOrderByDescendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> getOrder() {
        return Comparator.comparing(Student::getRedId).reversed();
    }
}
