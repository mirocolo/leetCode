package question.bytedance;

import junit.framework.LeetCodeTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/24 20:22
 */
@RunWith(Parameterized.class)
public class Application1OnMergeKListsTest extends LeetCodeTestCase {
    private Application1OnMergeKLists application1 = new Application1OnMergeKLists();

    private ListNode[] param;

    private ListNode res;

    public Application1OnMergeKListsTest(ListNode[] param, ListNode res) {
        this.param = param;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {
                                new ListNode[]{
                                        ListNode.createListNodeByIntArray(1, 4, 5),
                                        ListNode.createListNodeByIntArray(1, 3, 4),
                                        ListNode.createListNodeByIntArray(2, 6)
                                },
                                ListNode.createListNodeByIntArray(1, 1, 2, 3, 4, 4, 5, 6)
                        },


                });
    }

    @Test
    public void mergeKLists() {
        ListNode listNode = application1.mergeKListsV2(param);
        Assert.assertEquals("resUnEqual", res, listNode);
    }
}