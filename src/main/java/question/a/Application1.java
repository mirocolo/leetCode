package question.a;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Function：
 *
 * @author HeXin
 * @date 2019年11月22日 11:24
 * @since JDK 1.8
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 */
public class Application1 {

	public int[] twoSum(int[] numArray, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numArray.length > 0 ? numArray.length : 16);
		for (int i = 0; i < numArray.length; i++) {
			int complement = target - numArray[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(numArray[i], i);
		}
		throw new IllegalArgumentException("no answer");
	}
}
