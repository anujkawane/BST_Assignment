package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;

import java.util.Comparator;

public class NameOrderByAscendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> order() {
        return Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getFirstName);

    }
}
