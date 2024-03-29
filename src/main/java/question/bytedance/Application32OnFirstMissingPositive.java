package question.bytedance;

/**
 * @Description: 41. 缺失的第一个正数
 * @Author 何鑫
 * @Date 2022/12/8 15:30
 */
public class Application32OnFirstMissingPositive {
    /**
     * 41. 缺失的第一个正数
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * <p>
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5 * 105
     * -231 <= nums[i] <= 231 - 1
     */

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }

            for (int i = 0; i < n; i++) {
                int tempNum = Math.abs(nums[i]);
                if (tempNum <= n) {
                    nums[tempNum - 1] = -Math.abs(nums[tempNum - 1]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }
}
