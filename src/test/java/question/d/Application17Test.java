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
 * @Date 2022/7/14 15:55
 */
@RunWith(Parameterized.class)
public class Application17Test extends LeetCodeTestCase<Application17> {

    private final String input;
    private final List<String> expect;

    public Application17Test(String input, List<String> expect) {
        this.input = input;
        this.expect = expect;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2",List.of("a","b","c")}
        });
    }

    @Test
    public void letterCombinations() {
        List<String> strings = instance.letterCombinations(input);
        Assert.assertEquals(expect,strings);
    }
}