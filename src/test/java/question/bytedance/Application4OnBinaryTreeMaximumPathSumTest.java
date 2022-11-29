package question.bytedance;

import junit.framework.LeetCodeTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/25 14:39
 */
@RunWith(Parameterized.class)
public class Application4OnBinaryTreeMaximumPathSumTest extends LeetCodeTestCase {

    private Application4OnBinaryTreeMaximumPathSum app = new Application4OnBinaryTreeMaximumPathSum();

    private TreeNode treeNode;

    private int maxValue;

    public Application4OnBinaryTreeMaximumPathSumTest(TreeNode treeNode, int maxValue) {
        this.treeNode = treeNode;
        this.maxValue = maxValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{

                        {
                                new TreeNode(1,new TreeNode(2),new TreeNode(3)),
                                6,
                        },

                });
    }

    @Test
    public void maxPathSum() {
        int res = app.maxPathSum(treeNode);
        Assert.assertEquals("resUnEqual", maxValue, res);
    }
}