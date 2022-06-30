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
 * @Date 2022/6/29 18:23
 */
@RunWith(Parameterized.class)
public class Application6Test extends TestCase {
    Application6 application6;

    private String input;
    private int numRows;
    private String result;

    public Application6Test(String input, int num, String result) {
        this.input = input;
        this.numRows = num;
        this.result = result;
    }

    @Before
    public void setUp() {
        application6 = new Application6();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"},
                {"abc", 1, "abc"},
                {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"}

        });
    }

    @Test
    public void convert() {
        String res = application6.convert(input, numRows);
        Assert.assertEquals(this.result, res);
    }

}