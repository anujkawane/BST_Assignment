package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;

import java.util.Comparator;

/**
 * Ascending order strategy to order tree by the last name
 * and then by the first name if the two last names are equal.
 */
public class NameOrderByAscendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> getOrder() {
        return Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getFirstName);

    }
}
