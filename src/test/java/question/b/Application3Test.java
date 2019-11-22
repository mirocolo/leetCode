package question.b;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Function：
 *
 * @author HeXin
 * @date 2019年11月22日 14:24
 * @since JDK 1.8
 */
@RunWith(Parameterized.class)
public class Application3Test {
	private Application3 application3 =new Application3();
	private String inputStr;
	private int expected;

	public Application3Test(String inputStr, int maxLongestSubStringLength) {
		this.inputStr = inputStr;
		this.expected = maxLongestSubStringLength;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{{"abcabcbb",3},{"bbbbb",1},{"pwwkew",3},{"aaabcdeabcde",5}});
	}

	@Test
	public void lengthOfLongestSubstring() {
		int result = application3.lengthOfLongestSubstring(inputStr);
		Assert.assertEquals("求解最大子串长度错误",result,expected);
	}
}