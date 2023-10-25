/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (66.24%)
 * Likes:    1762
 * Dislikes: 0
 * Total Accepted:    420.7K
 * Total Submissions: 635.2K
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

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0279_PerfectSquares {
// @lc code=start
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;
            for(int i = 0; i <= n; i++){
                for(int j = i; j <= n; j++){
                    if(j < i * i) continue;
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
            return dp[n];
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        int n = 13;
        Assert.assertEquals(2, solution.numSquares(n));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int n = 12;
        Assert.assertEquals(3, solution.numSquares(n));
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int n = 1;
        Assert.assertEquals(1, solution.numSquares(n));
    }
}

