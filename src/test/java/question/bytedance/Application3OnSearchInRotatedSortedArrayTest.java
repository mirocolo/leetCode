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
 * @Date 2022/11/25 10:59
 */
@RunWith(Parameterized.class)
public class Application3OnSearchInRotatedSortedArrayTest extends LeetCodeTestCase {
    private Application3OnSearchInRotatedSortedArray app = new Application3OnSearchInRotatedSortedArray();

    private int[] num;
    private int target;

    private int res;

    public Application3OnSearchInRotatedSortedArrayTest(int[] num, int target, int res) {
        this.num = num;
        this.target = target;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
//                        {
//                                new int[]{4, 5, 6, 7, 0, 1, 2},
//                                0,
//                                4
//                        },
//                        {
//                                new int[]{4, 5, 6, 7, 0, 1, 2},
//                                3,
//                                -1
//                        },
                        {
                                new int[]{4, 5, 6, 7, 0, 1, 2},
                                4,
                                0
                        },

                });
    }

    @Test
    public void search() {
        int search = app.searchResInt(num, target);
        Assert.assertEquals("resUnEqual", res, search);
    }
}