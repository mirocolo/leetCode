package question.d;

import junit.framework.LeetCodeTestCase;
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
 * @Date 2022/7/1 15:23
 */
@RunWith(Parameterized.class)
public class Application9Test extends LeetCodeTestCase<Application9> {

    private final Integer input;
    private final Boolean result;

    public Application9Test(Integer input, Boolean result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {123,false},
                {121,true},
                {1,true},
                {12,false},
                {12121,true}
        });
    }



    @Test
    public void testIsPalindrome() {
        Boolean palindrome = instance.isPalindrome(input);
        assertEquals(result,palindrome);
    }
}