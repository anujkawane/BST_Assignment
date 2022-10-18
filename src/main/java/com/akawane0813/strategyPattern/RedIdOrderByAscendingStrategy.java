package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;

import java.util.Comparator;

public class RedIdOrderByAscendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> getOrder() {
        return Comparator.comparing(Student::getRedId);
    }
}
