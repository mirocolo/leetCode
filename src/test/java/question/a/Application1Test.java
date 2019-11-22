package question.a;


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
 * @date 2019年11月22日 13:57
 * @since JDK 1.8
 */
@RunWith(Parameterized.class)
public class Application1Test {

	private Application1 application1 = new Application1();
	private int[] numArray;
	private int target;
	private int[] expected;

	public Application1Test(int[] numArray, int target, int[] expected) {
		this.numArray = numArray;
		this.target = target;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{{new int[]{2, 7, 11, 15}, 9,new int[]{0,1}}});
	}

	@Test
	public void twoSum() {
		int[] result = application1.twoSum(numArray,target);
		Assert.assertArrayEquals("算法两数相加错误",result,expected);
	}

}