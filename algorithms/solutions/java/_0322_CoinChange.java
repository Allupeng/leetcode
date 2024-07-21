/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (48.16%)
 * Likes:    2808
 * Dislikes: 0
 * Total Accepted:    814.5K
 * Total Submissions: 1.7M
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

import java.util.Arrays;

public class _0322_CoinChange {
// @lc code=start
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++){
                for (int coin : coins){
                    if (i - coin >= 0){
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
// @lc code=end
}

