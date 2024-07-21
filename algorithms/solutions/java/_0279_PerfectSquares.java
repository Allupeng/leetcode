/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (66.78%)
 * Likes:    1954
 * Dislikes: 0
 * Total Accepted:    514.7K
 * Total Submissions: 770.8K
 * Testcase Example:  '12'
 *
 * Given an integer n, return the least number of perfect square numbers that
 * sum to n.
 * 
 * A perfect square is an integer that is the square of an integer; in other
 * words, it is the product of some integer with itself. For example, 1, 4, 9,
 * and 16 are perfect squares while 3 and 11 are not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

import java.util.Arrays;

public class _0279_PerfectSquares {
// @lc code=start
    class Solution {
        public int numSquares(int n) {
            if (n == 0) return 0;
            // dp[i] 代表由完全平方数组成到i所需要的完全平方数数量
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= Math.sqrt(i); j++){
                    if (i - j * j >= 0){
                        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                    }else{
                        dp[i] = dp[i - 1];
                    }
                }
            }
            return dp[n];
        }
    }
// @lc code=end
}

