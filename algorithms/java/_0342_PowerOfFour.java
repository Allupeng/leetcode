/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] Power of Four
 *
 * https://leetcode.cn/problems/power-of-four/description/
 *
 * algorithms
 * Easy (52.96%)
 * Likes:    354
 * Dislikes: 0
 * Total Accepted:    136.9K
 * Total Submissions: 258.5K
 * Testcase Example:  '16'
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return
 * false.
 * 
 * An integer n is a power of four, if there exists an integer x such that n ==
 * 4^x.
 * 
 * 
 * Example 1:
 * Input: n = 16
 * Output: true
 * Example 2:
 * Input: n = 5
 * Output: false
 * Example 3:
 * Input: n = 1
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= n <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */

public class _0342_PowerOfFour {
// @lc code=start
    class Solution {
        public boolean isPowerOfFour(int n) {
            //log ab = log cb / log ca
            //判断 log 4n 是否为整数即判断 log 10 n / log 104 是否为整数
            double div = Math.log10(n) / Math.log10(4);
            return n > 0 && (div == Math.floor(div));
        }
    }
// @lc code=end
}

