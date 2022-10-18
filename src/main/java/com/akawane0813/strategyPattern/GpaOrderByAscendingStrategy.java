package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;

import java.util.Comparator;

public class GpaOrderByAscendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> getOrder() {
        Comparator<Student> comparator = (Student object1,Student object2)-> {
            Integer b1 = (int) Math.round(object1.getGpa());
            Integer b2 = (int) Math.round(object2.getGpa());
            if(b1 == b2)  {
                return object1.getRedId().compareTo(object2.getRedId());
            }
            return Integer.compare(b1,b2);
        };
        return comparator;
    }
}
