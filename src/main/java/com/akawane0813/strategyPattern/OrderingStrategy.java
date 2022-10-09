package com.akawane0813.strategyPattern;

import com.akawane0813.Student;

import java.util.Comparator;

public interface OrderingStrategy {
    Comparator<Student> sort();
}
