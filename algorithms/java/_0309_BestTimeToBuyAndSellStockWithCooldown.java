/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (64.19%)
 * Likes:    1560
 * Dislikes: 0
 * Total Accepted:    267.4K
 * Total Submissions: 416.6K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * 
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * 
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0309_BestTimeToBuyAndSellStockWithCooldown {
// @lc code=start
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0){
                return 0;
            }
            // 有四种状态
            // 0. 持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
            // 1. 保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
            // 2. 今天卖出股票
            // 3. 今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
            int[][] dp = new int[prices.length][4];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            dp[0][2] = 0;
            dp[0][3] = 0;
            for (int i = 1; i < prices.length; i++){
                /**
                 * 持有股票状态（状态一）由以下几点转化而来
                 * 前一天持有股票的状态
                 * 保持卖出股票的状态 - price[i]
                 * 前一天为冷冻期，今天买入price[i]
                 */
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
                /**
                 * 保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
                 *
                 */
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
                dp[i][2] = dp[i - 1][0] + prices[i];
                dp[i][3] = dp[i - 1][2];

            }
            return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
        }
    }
// @lc code=end

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
        int[] prices3 = {1, 4, 2};
        assertEquals(3, solution.maxProfit(prices3));

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
        assertEquals(6, solution.maxProfit(prices8));
    }

}
