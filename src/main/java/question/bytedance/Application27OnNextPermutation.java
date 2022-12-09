package question.bytedance;

import java.util.Arrays;

/**
 * @Description: 下一个排列
 * @Author 何鑫
 * @Date 2022/12/7 15:40
 */
public class Application27OnNextPermutation {
    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 标准的“下一个排列”算法可以描述为：
     * <p>
     * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 将 A[i] 与 A[k] 交换
     * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     * <p>
     * 作者：imageslr
     * 链接：https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution {
        public void nextPermutation(int[] nums) {
            int length = nums.length;
            if (length <= 1) {
                return;
            }
            int i = nums.length - 2, j = nums.length - 1 , k = nums.length-1;
            while(i >= 0){
                if(nums[i] < nums[j]){
                    break;
                }
                i--; j--;
            }

            //本身就是最后一个排列（全部降序）， 把整体整个翻转变升序进行返回
            if (i < 0) {
                reverse(nums, 0, nums.length - 1);
                return;
            }


            for (int l = nums.length-1; l >= 0; l--) {
                if (nums[i] >= nums[l]) {
                    k--;
                } else {
                    swap(nums, i, k);
                    break;
                }
            }


            reverse(nums, j, length - 1);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private void reverse(int[] nums, int i, int j) {
            while (i < j) {
                swap(nums, i++, j--);
            }
        }

        public static void main(String[] args) {
            int[] nums = {1, 5,1};
            new Solution().nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
