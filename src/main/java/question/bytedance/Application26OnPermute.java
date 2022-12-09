package question.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 全排列
 * @Author 何鑫
 * @Date 2022/12/7 15:02
 */
public class Application26OnPermute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            List<Integer> outPut = new ArrayList<>();
            for (int num : nums) {
                outPut.add(num);
            }
            int n = nums.length;
            backStack(ans, outPut, n, 0);
            return ans;
        }

        private void backStack(List<List<Integer>> ans, List<Integer> outPut, int n, int index) {
            if (index == n) {
                ans.add(new ArrayList<>(outPut));
            }
            for (int i = index; i < n; i++) {
                Collections.swap(outPut, index, i);
                backStack(ans, outPut, n, index + 1);
                Collections.swap(outPut, index, i);
            }
        }
    }
}
