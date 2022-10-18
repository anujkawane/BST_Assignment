import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.Student;
import com.akawane0813.strategyPattern.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrategyPatternTest {

    private List<Student> testData = Arrays.asList(
            new Student(825890105, "George", "Jones", 3.59),
            new Student(825890103, "Susan", "Smith", 3.67),
            new Student(825890102, "Kevin", "Williams",3.23),
            new Student(825890104, "Anthony", "Harris",2.49),
            new Student(825890101, "AnIan", "Vazquezuj",3.99),
            new Student(825890106, "Kristy", "Williams",4.0),
            new Student(825890107, "Katherine", "Hurst",3.08),
            new Student(825890108, "Stacey", "Gordon",2.79),
            new Student(825890109, "Catherine", "Green",4.0),
            new Student(825890110, "Jessica", "Martin",3.99)
    );


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
