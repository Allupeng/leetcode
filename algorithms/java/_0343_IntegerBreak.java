/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.cn/problems/integer-break/description/
 *
 * algorithms
 * Medium (62.17%)
 * Likes:    1238
 * Dislikes: 0
 * Total Accepted:    270.4K
 * Total Submissions: 435K
 * Testcase Example:  '2'
 *
 * Given an integer n, break it into the sum of k positive integers, where k >=
 * 2, and maximize the product of those integers.
 * 
 * Return the maximum product you can get.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 58
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0343_IntegerBreak {
// @lc code=start
    class Solution {
        public int integerBreak(int n) {
            // dp[i]代表的 i的最大乘积
            // 1 <= j < i
            // dp[i] = max(dp[j], dp[i - j])
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++){
                for (int j = 1; j < i; j++){
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        Assert.assertEquals(36, solution.integerBreak(10));
    }
}

