package question.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 四数之和
 * @Author 何鑫
 * @Date 2022/7/14 16:14
 */
public class Application18 {
    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     * <p>
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (null == nums || nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            long min1 = getSum(nums[k], nums[k + 1], nums[k + 2], nums[k + 3]);
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            long max1 = getSum(nums[k], nums[length - 1], nums[length - 2], nums[length - 3]);
            if (max1 < target) {
                continue;
            }
            for (int i = k + 1; i < length - 2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                if (i != k + 1) {
                    long min = getSum(nums[k], nums[i], nums[l], nums[l + 1]);
                    if (min > target) {
                        break;
                    }
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                long max = getSum(nums[k], nums[i], nums[r], nums[r - 1]);
                if (max < target) {
                    continue;
                }
                while (r > l) {
                    long curr = getSum(nums[k], nums[i], nums[l], nums[r]);
                    if (curr == target) {
                        result.add(List.of(nums[k], nums[i], nums[l], nums[r]));
                        r--;
                        l++;
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }

                        while (r > l && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    } else if (curr > target) {
                        r--;

                    } else {
                        l++;
                    }
                }

            }


        }
        return result;
    }

    public long getSum(int a, int b, int c, int d) {
        return (long) a + (long) b + (long) c + (long) d;
    }
}
