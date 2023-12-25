/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * algorithms
 * Medium (71.99%)
 * Likes:    2163
 * Dislikes: 0
 * Total Accepted:    883.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * You are given an integer array prices where prices[i] is the price of a
 * given stock on the i^th day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit
 * = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
 * 3.
 * Total profit is 4 + 3 = 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Total profit is 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the
 * stock to achieve the maximum profit of 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0122_BestTimeToBuyAndSellStockIi {
// @lc code=start
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0){
                return 0;
            }
            // 两种状态
            // 0 持有股票 (前一天或者当天买入)
            // 1 卖出股票（前一天卖出或者当天卖出）
            int[][] dp =  new int[prices.length][2];
            dp[0][0] = -prices[0];
            dp[0][1] = 0;
            for (int i = 1; i < prices.length; i++){
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            }
            return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]);
        }
    }
// @lc code=end

    // greedy algorithm
    private int maxProfit(int[] prices) {
        // a profit must buy on a day and sell on a day.
        int profits = 0;
        if (prices.length < 2){
            // can buy but can't sell
            return 0;
        }
        for (int i = 1; i < prices.length; i++){
            if (prices[i] - prices[i - 1] > 0){
                profits += prices[i] - prices[i - 1];
            }
        }
        return profits;
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
        assertEquals(8, solution.maxProfit(prices5));

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
}

