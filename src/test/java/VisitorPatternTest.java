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
        BinarySearchTree emptyBST = new BinarySearchTree();

        TreePathVisitor visitor = new TreePathVisitor();
        emptyBST.getRoot().accept(visitor);

        Assert.assertEquals(visitor.getAveragePathLength(), (Object) 0.0);
    }

    @Test
    public void testMaximumPathLengthOfEmptyTree(){
        BinarySearchTree emptyBST = new BinarySearchTree();

        TreePathVisitor visitor = new TreePathVisitor();
        emptyBST.getRoot().accept(visitor);

        Assert.assertEquals(visitor.getMaximumPathLength(), 0);
    }
}
