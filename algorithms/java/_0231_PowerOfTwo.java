/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] Power of Two
 *
 * https://leetcode.cn/problems/power-of-two/description/
 *
 * algorithms
 * Easy (49.96%)
 * Likes:    633
 * Dislikes: 0
 * Total Accepted:    307.8K
 * Total Submissions: 616.2K
 * Testcase Example:  '1'
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2^x.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 3
 * Output: false
 * 
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

public class _0231_PowerOfTwo {
// @lc code=start
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n < 0){
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }
// @lc code=end
}

