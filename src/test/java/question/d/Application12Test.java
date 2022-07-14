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
 * @Date 2022/7/14 10:41
 */
@RunWith(Parameterized.class)
public class Application12Test extends LeetCodeTestCase<Application12> {

    private int input;
    private String expect;

    public Application12Test(int input, String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1,"I"},
                {4,"VI"},
                {9,"XI"},
                {1994,"MCMXCIV"}
        });
    }


    @Test
    public void intToRoman() {
        String s = instance.intToRoman(input);
        Assert.assertEquals(expect,s);
    }
}