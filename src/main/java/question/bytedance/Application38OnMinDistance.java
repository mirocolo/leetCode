package question.bytedance;

/**
 * @Description: 72. 编辑距离
 * @Author 何鑫
 * @Date 2022/12/9 14:40
 */
public class Application38OnMinDistance {
    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     * <p>
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/edit-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution {
        public int minDistance(String word1, String word2) {
            int n = word1.length();
            int m = word2.length();
            if (n == 0 || m == 0) {
                return n + m;
            }
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i < n + 1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < m + 1; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    int left = dp[i - 1][j] + 1;
                    int down = dp[i][j - 1] + 1;
                    int leftDown = dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        leftDown += 1;
                    }
                    dp[i][j] = Math.min(left, Math.min(down, leftDown));
                }
            }
            return dp[n][m];
        }
    }
}
