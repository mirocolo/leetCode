package question.d;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/6/17 15:57
 */
@RunWith(Parameterized.class)
public class ApplicationTest extends TestCase {

    Application application =new Application();

    private String input;
    private String result;

    public ApplicationTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"abbc","bb"}, {"abbbdd","bbb"},{"abcdefghijklmnopqrstuvwxyzzzyxwvudsdasdasd","uvwxyzzzyxwvu"}});
    }

    @Test
    public void longestPalindromeVer1() {

        String result = application.longestPalindromeVer1(input);
        Assert.assertEquals(this.result, result);


        String result2 = application.longestPalindromeVer2(input);
        Assert.assertEquals(this.result, result2);


        String result3 = application.longestPalindrome(input);
        Assert.assertEquals(this.result, result3);

    }
}