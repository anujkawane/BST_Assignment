import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.Student;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinarySearchTreeTest {

    private List<Student> testData;
    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp() {
        testData = new TestData().getTestData();
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);
    }

    @Test
    public void testContainsIfPresent(){
        Assert.assertTrue(binarySearchTree.contains(testData.get(2)));
    }

    @Test
    public void testContainsIfNotPresent(){
        Student student = new Student(825890200, "Anuj", "Kawane",4.0);

        Assert.assertFalse(binarySearchTree.contains(student));
    }

    @Test
    public void testSize(){
        Assert.assertEquals(binarySearchTree.size(), testData.size());
    }

    @Test
    public void testAddElement(){
        Student student = new Student(825890200, "Anuj", "Kawane",4.0);
        binarySearchTree.add(student);

        Assert.assertTrue(binarySearchTree.add(student));
    }

    @Test
    public void testClearTree(){
        Assert.assertEquals(binarySearchTree.size(), testData.size());
        binarySearchTree.clear();

        Assert.assertEquals(binarySearchTree.size(), 0);
    }

}
