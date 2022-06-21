package question.dymaicprograming;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/6/21 10:17
 */
@RunWith(Parameterized.class)
public class ApplicationTest2 extends TestCase {

    Application application = new Application();

    private int[] input;
    private Integer result;

    public ApplicationTest2(int[] input, int result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 1},
                {new int[]{1,5,3,4,6}, 4},
                {new int[]{1,5,6,3,4}, 3},
                {new int[]{1,5,6,3,4,7,8,9}, 6},
                {new int[]{1,5,6,3,4,7,6,9}, 5},
                {new int[]{1,3,6,5,4,7,6,9}, 5},

        });
    }

    @Test
    public void longestUpArrayNum() {
        Integer outPut = application.longestUpArrayNum(input);
        Assert.assertEquals(result, outPut);
    }



}