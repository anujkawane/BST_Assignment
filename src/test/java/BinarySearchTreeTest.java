import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {

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
    public void testContainsIfPresent(){

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);
        Student student = new Student(825890106, "Kristy", "Williams",4.0);

        Assert.assertEquals(binarySearchTree.contains(student), true);
    }

    @Test
    public void testContainsIfNotPresent(){

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);
        Student student = new Student(825890200, "Anuj", "Kawane",4.0);

        Assert.assertEquals(binarySearchTree.contains(student), false);
    }

    @Test
    public void testSize(){

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        Assert.assertEquals(binarySearchTree.size(), testData.size());
    }

    @Test
    public void testAddElement(){

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Student student = new Student(825890200, "Anuj", "Kawane",4.0);
        binarySearchTree.add(student);

        Assert.assertEquals(binarySearchTree.contains(student), true);
    }

    @Test
    public void testClearTree(){

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);
        Assert.assertEquals(binarySearchTree.size(), testData.size());
        binarySearchTree.clear();

        Assert.assertEquals(binarySearchTree.size(), 0);
    }

}
