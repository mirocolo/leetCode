package question.d;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/6/30 17:11
 */
@RunWith(Parameterized.class)
public class Application7Test extends TestCase {

    private Application7 application7;
    private Integer input;
    private Integer outPut;

    public Application7Test(Integer input, Integer outPut) {
        this.input = input;
        this.outPut = outPut;
    }

    @Before
    public void setUp(){
        application7 = new Application7();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {123,321},
                {1234567,7654321},
                {Integer.MAX_VALUE,0}

        });
    }

    @Test
    public void convert() {
        Integer res = application7.reverse(input);
        Assert.assertEquals(this.outPut, res);
    }
}