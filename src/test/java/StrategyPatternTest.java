import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.Student;
import com.akawane0813.strategyPattern.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyPatternTest {

    private List<Student> testData = new TestData().getTestData();

    @Test
    public void testGpaOrderByAscendingStrategy(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>(new GpaOrderByAscendingStrategy().getOrder());
        bst.addAll(testData);
        Comparator<Student> comparator = (Student object1,Student object2)-> {
            Integer b1 = (int) Math.round(object1.getGpa());
            Integer b2 = (int) Math.round(object2.getGpa());
            if(b1 == b2)  {
                return object1.getRedId().compareTo(object2.getRedId());
            }
            return Integer.compare(b1,b2);
        };
        testData.sort(comparator);
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);

    }

    @Test
    public void testGpaOrderByDescendingStrategy(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>(new GpaOrderByDescendingStrategy().getOrder());
        bst.addAll(testData);
        Comparator<Student> comparator = (Student object1,Student object2)-> {
            Integer b1 = (int) Math.round(object1.getGpa());
            Integer b2 = (int) Math.round(object2.getGpa());
            if(b1 == b2)  {
                return object1.getRedId().compareTo(object2.getRedId());
            }
            return Integer.compare(b1,b2);
        };
        testData.sort(comparator.reversed());
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testNameOrderByAscendingStrategy(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>(new NameOrderByAscendingStrategy().getOrder());

        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName));
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testNameOrderByDescendingStrategy(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>(new NameOrderByDescendingStrategy().getOrder());

        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).reversed());
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testRedIdOrderByAscendingStrategy(){

        BinarySearchTree<Student> bst = new BinarySearchTree<>(new RedIdOrderByAscendingStrategy().getOrder());

        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getRedId));
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testRedIdOrderByDescendingStrategy(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>(new RedIdOrderByDescendingStrategy().getOrder());

        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getRedId).reversed());
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);
    }

    @Test
    public void testDefaultOrder(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>();

        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getRedId));
        List<Student> expectedOrder = testData;
        List<Student> actualOrder = new ArrayList<>();

        bst.forEach(actualOrder::add);
        assertEquals(expectedOrder, actualOrder);
    }
}
