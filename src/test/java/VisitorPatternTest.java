import com.akawane0813.BinarySearchTree;
import com.akawane0813.model.Student;
import com.akawane0813.visitorPattern.NullNodeCountVisitor;
import com.akawane0813.visitorPattern.TreePathVisitor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VisitorPatternTest {

    private List<Student> testData = new TestData().getTestData();

    @Test
    public void testNullNodeCount() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        NullNodeCountVisitor visitor = new NullNodeCountVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(11, visitor.getNullNodeCount());
    }

    @Test
    public void testMaximumPathLength() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        TreePathVisitor visitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(5, visitor.getMaximumPathLength());
    }

    @Test
    public void testAveragePathLength() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addAll(testData);

        TreePathVisitor visitor = new TreePathVisitor();
        binarySearchTree.getRoot().accept(visitor);

        Assert.assertEquals(3.3333333333333335, (Object) visitor.getAveragePathLength());
    }

    @Test
    public void testAveragePathLengthOfEmptyTree() {
        BinarySearchTree emptyBST = new BinarySearchTree();

        TreePathVisitor visitor = new TreePathVisitor();
        emptyBST.getRoot().accept(visitor);

        Assert.assertEquals((Object) 0.0, visitor.getAveragePathLength());
    }

    @Test
    public void testMaximumPathLengthOfEmptyTree() {
        BinarySearchTree emptyBST = new BinarySearchTree();

        TreePathVisitor visitor = new TreePathVisitor();
        emptyBST.getRoot().accept(visitor);

        Assert.assertEquals(0, visitor.getMaximumPathLength());
    }
}
