package question.d;

import junit.framework.LeetCodeTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import question.dymaicprograming.Application10;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/7/4 15:14
 */
@RunWith(Parameterized.class)
public class Application10Test extends LeetCodeTestCase<Application10> {

    private String s;
    private String p;
    private Boolean match;

    public Application10Test(String s, String p, Boolean match) {
        this.s = s;
        this.p = p;
        this.match = match;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"a","a",true},
                {"aa","a",false},
                {"aa","a*",true},
                {"ab",".*",true},
                {"aaab","a*b",true},
        });
    }

    @Test
    public void isMatch() {
        Boolean res = instance.isMatch(s,p);
        Assert.assertEquals("正则表达式匹配",match,res);
    }
}