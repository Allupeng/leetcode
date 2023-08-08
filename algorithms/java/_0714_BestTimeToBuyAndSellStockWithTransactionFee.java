/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 *
 * algorithms
 * Medium (75.34%)
 * Likes:    937
 * Dislikes: 0
 * Total Accepted:    223.6K
 * Total Submissions: 296.8K
 * Testcase Example:  '[1,3,2,8,4,9]\n2'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day, and an integer fee representing a transaction fee.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like, but you need to pay the transaction fee for each
 * transaction.
 * 
 * Note:
 * 
 * 
 * You may not engage in multiple transactions simultaneously (i.e., you must
 * sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and
 * sale.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 5 * 10^4
 * 1 <= prices[i] < 5 * 10^4
 * 0 <= fee < 5 * 10^4
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0714_BestTimeToBuyAndSellStockWithTransactionFee {
// @lc code=start
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices.length <= 1){
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
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
            }
            return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]), 0);
        }
    }
// @lc code=end
    @Test
    public void testMaxProfit() {
        Solution solution = new Solution();

        // Test case 1: Empty prices array
        int[] prices1 = {};
        assertEquals(0, solution.maxProfit(prices1, 2));

        // Test case 2: One price
        int[] prices2 = {1};
        assertEquals(0, solution.maxProfit(prices2, 2));

        // Test case 3: Two prices
        int[] prices3 = {1, 2};
        assertEquals(0, solution.maxProfit(prices3, 2));

        // Test case 4: Three prices
        int[] prices4 = {3, 2, 1};
        assertEquals(0, solution.maxProfit(prices4, 2));

        // Test case 5: Four prices
        int[] prices5 = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(2, solution.maxProfit(prices5, 2));

        // Test case 6: Five prices
        int[] prices6 = {1, 2, 3, 4, 5};
        assertEquals(3, solution.maxProfit(prices6, 1));

        // Test case 7: Six prices
        int[] prices7 = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(prices7, 2));

        // Test case 8: Seven prices
        int[] prices8 = {6, 1, 3, 2, 4, 7};
        assertEquals(4, solution.maxProfit(prices8, 1));
    }
}

