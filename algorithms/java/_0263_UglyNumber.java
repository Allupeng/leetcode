/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] Ugly Number
 *
 * https://leetcode.cn/problems/ugly-number/description/
 *
 * algorithms
 * Easy (50.43%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    165.4K
 * Total Submissions: 328K
 * Testcase Example:  '6'
 *
 * An ugly number is a positive integer whose prime factors are limited to 2,
 * 3, and 5.
 * 
 * Given an integer n, return true if n is an ugly number.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are
 * limited to 2, 3, and 5.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= n <= 2^31 - 1
 * 
 * 
 */

public class _0263_UglyNumber {
// @lc code=start
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false;
            while (n % 2 == 0) n /= 2;
            while (n % 3 == 0) n /= 3;
            while (n % 5 == 0) n /= 5;
            return n == 1;
        }
    }
// @lc code=end
}

