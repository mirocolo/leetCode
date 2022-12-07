package question.bytedance;

/**
 * @Description: 最长有效括号
 * @Author 何鑫
 * @Date 2022/12/1 15:48
 */
public class Application13OnLongestValidParentheses {


    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * <p>
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * <p>
     * 输入：s = ""
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution {
        public static final char LEFT = '(';
        public static final char RIGHT = ')';

        /**
         * 动态规划
         *
         * @param s
         * @return
         */
        public int longestValidParentheses(String s) {
            int maxAns = 0;
            int[] dp = new int[s.length()];

            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == RIGHT) {
                    if (s.charAt(i - 1) == LEFT) {
                        dp[i] = ((i >= 2) ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] -1 >= 0 && s.charAt(i - dp[i - 1] - 1) == LEFT) {
                        // 如果存在跨越有限区的长度 需要 i - 上一有效子串以及 新增的左右两个括号的长度 获取 上一转移值
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxAns = Math.max(maxAns, dp[i]);
                }
            }

            return maxAns;
        }
    }
}
