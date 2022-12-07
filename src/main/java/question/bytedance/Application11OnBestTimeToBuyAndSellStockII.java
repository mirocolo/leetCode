package question.bytedance;

/**
 * @Description: 买卖股票的最佳时机
 * @Author 何鑫
 * @Date 2022/11/30 11:10
 */
public class Application11OnBestTimeToBuyAndSellStockII {

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      总利润为 4 。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 动态规划解法
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int[][] dp =new int[len][2];
            // 0：持有现金
            // 1：持有股票
            // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0

            // 不买入
            dp[0][0] = 0;
            // 买入
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                // cash
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // store
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[len - 1][0];

        }
    }

    /**
     * 贪心
     */
    class Solution2 {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                int num = prices[i] - prices[i - 1];
                if(num >0){
                    profit += num;
                }
            }
            return profit;
        }
    }

    class Solution3 {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, profit = 0;

            for (int price : prices) {
                min = Math.min(min, price);
                profit = Math.max(profit, price - min);
            }
            return profit;
        }
    }
}
