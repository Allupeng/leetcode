/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (46.51%)
 * Likes:    2499
 * Dislikes: 0
 * Total Accepted:    655.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _0322_CoinChange {
// @lc code=start
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for(int i = 0; i < coins.length; i++){
                for(int j = 0; j < dp.length; j++){
                    if(j - coins[i] < 0) continue;
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
            return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        }
    }
// @lc code=end

    @Test
    public void testCoinChangeWithValidInput() {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expected = 3;
        int actual = solution.coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void testCoinChangeWithZeroAmount() {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 0;
        int expected = 0;
        int actual = solution.coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void testCoinChangeWithZeroCoins() {
        Solution solution = new Solution();
        int[] coins = {};
        int amount = 5;
        int expected = -1;
        int actual = solution.coinChange(coins, amount);
        assertEquals(expected, actual);
    }

    @Test
    public void testCoinChangeWithTwoCoins() {
        Solution solution = new Solution();
        int[] coins = {2};
        int amount = 3;
        int expected = -1;
        int actual = solution.coinChange(coins, amount);
        assertEquals(expected, actual);
    }
}

