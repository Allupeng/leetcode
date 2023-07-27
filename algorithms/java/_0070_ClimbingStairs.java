/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.cn/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (54.06%)
 * Likes:    3137
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2.2M
 * Testcase Example:  '2'
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

import org.junit.Test;

public class _0070_ClimbingStairs {
// @lc code=start
    class Solution {
        public int climbStairs(int n) {
            // way(n) = way(n - 1) + way(n - 2)
            if (n == 1 || n == 2){
                return n;
            }
            int[] result = new int[n + 1];
            result[1] = 1;
            result[2] = 2;
            for (int i = 3; i <= n; i++){
                result[i] = result[i - 1] + result[i - 2];
            }
            return result[n];
        }
    }
// @lc code=end
    @Test
    public void test(){
        Solution solution = new Solution();
        assert 3 == solution.climbStairs(3);
    }
}

