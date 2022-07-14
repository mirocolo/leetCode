package question.d;

import java.util.Arrays;

/**
 * @Description: 最接近的三数之和
 * @Author 何鑫
 * @Date 2022/7/14 15:22
 */
public class Application16 {
    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * <p>
     * 返回这三个数的和。
     * <p>
     * 假定每组输入只存在恰好一个解。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0], target = 1
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
//        if(nums.length<3){
//            return 0;
//        }
        int ans = nums[0]+nums[1]+nums[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = length - 1;
            while (r > l) {
                int sum = nums[i] + nums[r] + nums[l];
                if(sum == target){
                    return sum;
                }else if (sum > target){
                    r = r - 1;
                }else {
                    l = l + 1;
                }
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
            }
        }

        return ans;
    }
}
