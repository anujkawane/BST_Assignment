import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.Student;
import com.akawane0813.visitorPattern.NullNodeCountVisitor;
import com.akawane0813.visitorPattern.TreePathVisitor;
import com.akawane0813.visitorPattern.Visitor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VisitorPatternTest {

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

    private static  List<Student> nullTestdata = new ArrayList<>();

    @Test
    public void testNullNodeCount(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        NullNodeCountVisitor visitor = new NullNodeCountVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(visitor.getCountNullNode(), 11);
    }

    @Test
    public void testMaximumPathLength(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        TreePathVisitor visitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(visitor.getMaximumPathLength(), 5);
    }

    @Test
    public void testAveragePathLength(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        TreePathVisitor visitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals((Object) visitor.getAveragePathLength(), 3.3333333333333335);
    }

    @Test
    public void testAveragePathLengthOfEmptyTree(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        TreePathVisitor visitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(visitor.getAveragePathLength(), (Object) 0.0);
    }

    @Test
    public void testMaximumPathLengthOfEmptyTree(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        TreePathVisitor visitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(visitor.getMaximumPathLength(), 0);
    }
}
