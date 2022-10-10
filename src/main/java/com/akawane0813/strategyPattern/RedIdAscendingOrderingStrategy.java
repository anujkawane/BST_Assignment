package com.akawane0813.strategyPattern;

import com.akawane0813.Student;

import java.util.Comparator;

public class RedIdAscendingOrderingStrategy implements OrderingStrategy {
    @Override
    public Comparator<Student> sort() {
        return Comparator.comparing(Student::getRedId);
    }
}