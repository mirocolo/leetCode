package question.d;

import junit.framework.LeetCodeTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/7/14 16:49
 */
@RunWith(Parameterized.class)
public class Application18Test extends LeetCodeTestCase<Application18> {

    private final int[] nums;
    private final int target;
    private final List<List<Integer>> expect;

    public Application18Test(int[] nums, int target, List<List<Integer>> expect) {
        this.nums = nums;
        this.target = target;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4},10,List.of(List.of(1,2,3,4))}
        });
    }



    @Test
    public void fourSum() {
        List<List<Integer>> res = instance.fourSum(nums, target);
        Assert.assertEquals(expect,res);
    }
}