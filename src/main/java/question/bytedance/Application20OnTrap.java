package question.bytedance;

/**
 * @Description: 接雨水
 * @Author 何鑫
 * @Date 2022/12/6 17:06
 */
public class Application20OnTrap {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public int trap(int[] height) {
            int length = height.length;
            int[] leftMax = new int[length];
            leftMax[0] = height[0];
            for (int i = 1; i < length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            int[] rightMax = new int[length];
            rightMax[length - 1] = height[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 0; i < length; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }

    class Solution2 {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left < right) {
                leftMax = Math.max(leftMax, height[left]);
                rightMax = Math.max(rightMax, height[right]);
                if (leftMax > rightMax) {
                    ans += rightMax - height[right];
                    -- right;
                } else {
                    ans += leftMax - height[left];
                    ++ left;
                }
            }
            return ans;
        }
    }
}
