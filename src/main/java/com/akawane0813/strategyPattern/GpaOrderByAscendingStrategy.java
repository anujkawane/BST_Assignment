package com.akawane0813.strategyPattern;

import com.akawane0813.model.Student;
import java.util.Comparator;

/**
 * Ascending order strategy to order tree by rounding student's gpa to the nearest integer
 * then order by RedId if rounded GPA is equal.
 */
public class GpaOrderByAscendingStrategy implements OrderStrategy {
    @Override
    public Comparator<Student> getOrder() {
        return (Student object1, Student object2)-> {
            Integer gpa1 = (int) Math.round(object1.getGpa());
            Integer gpa2 = (int) Math.round(object2.getGpa());
            if(gpa1 == gpa2)  {
                return object1.getRedId().compareTo(object2.getRedId());
            }
            return Integer.compare(gpa1,gpa2);
        };
    }
}
