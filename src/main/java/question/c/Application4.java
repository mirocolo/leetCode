package question.c;

/**
 * Function： 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3] nums2 = [2]
 *
 * 则中位数是 2.0 示例 2:
 *
 * nums1 = [1, 2] nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author HeXin
 * @date 2019年11月22日 15:08
 * @since JDK 1.8
 */
public class Application4 {
	public double findMedianSortedArrays(int[] arrayOne, int[] arrayTwo) {
		int n = arrayOne.length;
		int m = arrayTwo.length;
		if (n > m) {
			//保证数组1一定最短
			return findMedianSortedArrays(arrayTwo, arrayOne);
		}
		// Ci 为第i个数组的割,比如C1为2时表示第1个数组只有2个元素。LMaxi为第i个数组割后的左元素。RMini为第i个数组割后的右元素。
		//我们目前是虚拟加了'#'所以数组1是2*n长度
		int LMax1 = 0, LMax2 = 0, RMin1 = 0, RMin2 = 0, c1, c2, lo = 0, hi = 2 * n;

		while (lo <= hi) {
			//二分
			//c1是二分的结果
			c1 = (lo + hi) / 2;
			c2 = m + n - c1;
			LMax1 = (c1 == 0) ? Integer.MIN_VALUE : arrayOne[(c1 - 1) / 2];
			RMin1 = (c1 == 2 * n) ? Integer.MAX_VALUE : arrayOne[c1 / 2];
			LMax2 = (c2 == 0) ? Integer.MIN_VALUE : arrayTwo[(c2 - 1) / 2];
			RMin2 = (c2 == 2 * m) ? Integer.MAX_VALUE : arrayTwo[c2 / 2];

			if (LMax1 > RMin2) {
				hi = c1 - 1;
			} else if (LMax2 > RMin1) {
				lo = c1 + 1;
			} else {
				break;
			}
		}
		return (Math.max(LMax1, LMax2) + Math.min(RMin1, RMin2)) / 2.0;
	}


}
