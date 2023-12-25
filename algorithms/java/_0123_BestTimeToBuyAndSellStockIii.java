/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (59.01%)
 * Likes:    1477
 * Dislikes: 0
 * Total Accepted:    269.1K
 * Total Submissions: 455.9K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0123_BestTimeToBuyAndSellStockIii {
// @lc code=start
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0){
                return 0;
            }
            // 由于限制了最多交易两次，所以可以定义一个dp来决定状态
            // dp[0] 代表未交易
            // dp[1] 代表第一次买入
            // dp[2] 代表第一次卖出
            // dp[3] 代表第二次买入
            // dp[4] 代表第二次卖出
            // dp[i][j] 代表当到第i天时，对应操作的最大利润
            int[][] dp = new int[prices.length][5];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            dp[0][2] = 0;
            dp[0][3] = -prices[0];
            dp[0][4] = 0;
            for (int i = 1; i < prices.length; i++){
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            }
            return dp[prices.length - 1][4];
        }
    }

    @Test
    public void testMaxProfit() {
        Solution solution = new Solution();

        // Test case 1: Empty prices array
        int[] prices1 = {};
        assertEquals(0, solution.maxProfit(prices1));

        // Test case 2: One price
        int[] prices2 = {1};
        assertEquals(0, solution.maxProfit(prices2));

        // Test case 3: Two prices
        int[] prices3 = {1, 2};
        assertEquals(1, solution.maxProfit(prices3));

        // Test case 4: Three prices
        int[] prices4 = {3, 2, 1};
        assertEquals(0, solution.maxProfit(prices4));

        // Test case 5: Four prices
        int[] prices5 = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(6, solution.maxProfit(prices5));

        // Test case 6: Five prices
        int[] prices6 = {1, 2, 3, 4, 5};
        assertEquals(4, solution.maxProfit(prices6));

        // Test case 7: Six prices
        int[] prices7 = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(prices7));

        // Test case 8: Seven prices
        int[] prices8 = {6, 1, 3, 2, 4, 7};
        assertEquals(7, solution.maxProfit(prices8));
    }
// @lc code=end
}

