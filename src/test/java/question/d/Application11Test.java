package question.d;

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
 * @Date 2022/7/11 11:23
 */
@RunWith(Parameterized.class)
public class Application11Test extends LeetCodeTestCase<Application11> {

    private int[] input;
    private int expect;

    public Application11Test(int[] input, int expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1},1},
                {new int[]{1,8,6,2,5,4,8,3,7},49},
        });
    }

    @Test
    public void maxAreaTest(){
        int res = instance.maxArea(input);
        Assert.assertEquals(expect,res);
    }
}