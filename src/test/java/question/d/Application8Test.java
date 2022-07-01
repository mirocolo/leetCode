package question.d;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/7/1 10:10
 */
@RunWith(Parameterized.class)
public class Application8Test extends TestCase {

    private Application8 application8;

    private String input;
    private Integer output;


    public Application8Test(String input, Integer output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"123",123},
                {"12345678",12345678},
                {Integer.MAX_VALUE+"",Integer.MAX_VALUE},
                {Integer.MIN_VALUE+"",Integer.MIN_VALUE},
                {"2147483648",Integer.MAX_VALUE},
                {"-2147483649",Integer.MIN_VALUE}

        });
    }

    @Before
    public void setUp() throws Exception {
        application8 = new Application8();
    }

    @Test
    public void myAtoi() {
        Integer i = application8.myAtoi(input);
        assertEquals(output,i);
    }
}