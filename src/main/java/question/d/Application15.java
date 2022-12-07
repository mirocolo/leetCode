package question.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 三数之和
 * @Author 何鑫
 * @Date 2022/7/14 14:41
 */
public class Application15 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length < 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //排在前面的第一个数字已经大于0 不可能出现和为0
            if (nums[i] > 0) {
                return res;
            }
            // 需要和上一次枚举的数不相同
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1;
            int r = length - 1;
            while (r > l) {
                int tempRes = nums[i] + nums[l] + nums[r];
                if (tempRes == 0) {
                    // 找到一组答案后 继续二次扫描
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    // 快速缩小左右锚点，排除重复数值
                    while (l < r && nums[l] == nums[l + 1]) {
                        l = l + 1;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r = r - 1;
                    }
                    l = l + 1;
                    r = r -1;
                } else if (tempRes > 0) {
                    r = r - 1;
                } else {
                    l = l + 1;
                }
            }
        }
        return res;


    }
}
