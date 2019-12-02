package question.c;

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
 * @date 2019年11月22日 15:18
 * @since JDK 1.8
 */
@RunWith(Parameterized.class)
public class Application4Test {

	private Application4 application4 = new Application4();

	private int[] arrayOne;
	private int[] arrayTwo;
	private double expected;

	public Application4Test(int[] arrayOne, int[] arrayTwo, double expected) {
		this.arrayOne = arrayOne;
		this.arrayTwo = arrayTwo;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{{new int[]{1, 3}, new int[]{2}, 2.0}, {new int[]{1, 2}, new int[]{3, 4}, 2.5}});
	}

	@Test
	public void findMedianSortedArrays() {
		double result = application4.findMedianSortedArrays(arrayOne, arrayTwo);
		Assert.assertEquals(expected, result, 0.01d);
	}
}