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
public class ApplicationTest extends TestCase {

    Application application = new Application();

    private Integer input;
    private Integer result;

    public ApplicationTest(int input, int result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 1},
                {6, 2},
                {100,1},
                {10000,100},
                {100000,1000},
                {100006,1002}

        });
    }

    @Test
    public void moneyNum() {
        Integer outPut = application.moneyNum(input);
        Assert.assertEquals(result, outPut);
    }



}