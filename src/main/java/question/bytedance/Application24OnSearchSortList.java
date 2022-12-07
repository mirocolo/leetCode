package question.bytedance;

/**
 * @Description: 搜索旋转排序数组
 * @Author 何鑫
 * @Date 2022/12/7 13:11
 */
public class Application24OnSearchSortList {

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class Solution2 {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[l] <= nums[mid]) {
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                    // 左半边有序
                } else {
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                    // 右半边有序
                }
            }
            return -1;
        }
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int length = nums.length;
            if (length == 0) {
                return -1;
            }
            if (length == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int left = 0;
            int right = length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 若数组内 存在相同数字 导致有序数组无法定位 则收敛当前的左右扫描区间
                if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                    left++;
                    right--;
                }
                if (nums[left] <= nums[mid]) {
                    // 左半边有序 且 目标值在 左半边有序区间
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        // 左边有序 但目标值 在右半边区间 快速收缩
                        left = mid + 1;
                    }
                } else {
                    // 右半边有序 且目标值在 右半边有序区间
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        // 右半边有序 但目标值在 左半边 旋转区间
                        right = mid - 1;
                    }
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            {
                Solution solution = new Solution();
                int search = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
                System.out.println(search);
            }

            {
                Solution2 solution = new Solution2();
                int search = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
                System.out.println(search);
            }
        }
    }
}
