/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] Coin Change II
 *
 * https://leetcode.cn/problems/coin-change-ii/description/
 *
 * algorithms
 * Medium (70.62%)
 * Likes:    1121
 * Dislikes: 0
 * Total Accepted:    252.3K
 * Total Submissions: 357.3K
 * Testcase Example:  '5\n[1,2,5]'
 *
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the number of combinations that make up that amount. If that amount
 * of money cannot be made up by any combination of the coins, return 0.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: amount = 10, coins = [10]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 * 
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _0518_CoinChangeIi {
// @lc code=start
    class Solution {
        public int change(int amount, int[] coins) {
            //dp[j]为 amount为j时，能用coins找零的最大次数
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++){
                for (int j = coins[i]; j < amount + 1; j++){
                    if (j - coins[i] < 0){
                        continue;
                    }
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
            return dp[amount];
        }
    }
    // @lc code=end
    @Test
    public void testChangeWithZeroCoins() {
        Solution solution = new Solution();
        int[] coins = {};
        int amount = 5;
        int expected = 0;
        int actual = solution.change(amount, coins);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeWithValidInput() {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 5;
        int expected = 4;
        int actual = solution.change(amount, coins);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeWithZeroAmount() {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 0;
        int expected = 1;
        int actual = solution.change(amount, coins);
        assertEquals(expected, actual);
    }
}

