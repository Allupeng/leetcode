/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (45.99%)
 * Likes:    986
 * Dislikes: 0
 * Total Accepted:    197.9K
 * Total Submissions: 430.2K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * You are given an integer array prices where prices[i] is the price of a
 * given stock on the i^th day, and an integer k.
 * 
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions: i.e. you may buy at most k times and sell at most k times.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3),
 * profit = 3-0 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0188_BestTimeToBuyAndSellStockIv {
// @lc code=start
    class Solution {
        public int maxProfit(int k, int[] prices) {
            if(prices.length == 0){
                return 0;
            }
            //思路见 Problem.123
            int n = prices.length;
            int[][] dp = new int[n][2 * k + 1];
            dp[0][0] = 0;
            for (int j = 1; j <= 2*k; j++){
                if (j % 2 == 1){
                    dp[0][j] = -prices[0];
                }else {
                    dp[0][j] = 0;
                }
            }
            for (int i = 1; i < n; i++){
                for (int j = 1; j <= 2*k; j++){
                    dp[i][j] = (j % 2 == 1) ?
                            Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]) : Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
            return dp[n - 1][2 * k];
        }
    }
// @lc code=end

    @Test
    public void testMaxProfit() {
        Solution solution = new Solution();

        // Test case 1: Empty prices array
        int[] prices1 = {};
        assertEquals(0, solution.maxProfit(0, prices1));

        // Test case 2: One price
        int[] prices2 = {1};
        assertEquals(0, solution.maxProfit(0, prices2));

        // Test case 3: Two prices, k = 1
        int[] prices3 = {1, 2};
        assertEquals(1, solution.maxProfit(1, prices3));

        // Test case 4: Three prices, k = 1
        int[] prices4 = {3, 2, 1};
        assertEquals(0, solution.maxProfit(1, prices4));

        // Test case 5: Four prices, k = 2
        int[] prices5 = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(6, solution.maxProfit(2, prices5));

        // Test case 6: Five prices, k = 2
        int[] prices6 = {1, 2, 3, 4, 5};
        assertEquals(4, solution.maxProfit(2, prices6));

        // Test case 7: Six prices, k = 2
        int[] prices7 = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(2, prices7));

        // Test case 8: Seven prices, k = 3
        int[] prices8 = {6, 1, 3, 2, 4, 7};
        assertEquals(7, solution.maxProfit(3, prices8));
    }
}

