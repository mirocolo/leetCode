package question.d;

import junit.framework.LeetCodeTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/7/14 15:12
 */
@RunWith(Parameterized.class)
public class Application15Test extends LeetCodeTestCase<Application15> {

    private int[] input;
    private List<List<Integer>> expect;

    public Application15Test(int[] input, List<List<Integer>> expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, Collections.emptyList()},
                {new int[]{1,2,3}, Collections.emptyList()},
                {new int[]{-1,0,1}, List.of(List.of(-1,0,1))},
        });
    }

    @Test
    public void threeSum() {
        List<List<Integer>> lists = instance.threeSum(input);
        Assert.assertEquals(expect,lists);
    }
}