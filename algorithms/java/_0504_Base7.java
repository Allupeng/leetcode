/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] Base 7
 *
 * https://leetcode.cn/problems/base-7/description/
 *
 * algorithms
 * Easy (51.77%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    90.1K
 * Total Submissions: 174.1K
 * Testcase Example:  '100'
 *
 * Given an integer num, return a string of its base 7 representation.
 * 
 * 
 * Example 1:
 * Input: num = 100
 * Output: "202"
 * Example 2:
 * Input: num = -7
 * Output: "-10"
 * 
 * 
 * Constraints:
 * 
 * 
 * -10^7 <= num <= 10^7
 * 
 * 
 */

public class _0504_Base7 {
// @lc code=start
    class Solution {
        public String convertToBase7(int num) {
            // 10 进制转化为 7 进制
            if (num == 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            boolean isNegative = num < 0;
            if (isNegative) {
                num = -num;
            }
            while (num > 0) {
                sb.append(num % 7);
                num /= 7;
            }
            if (isNegative) {
                sb.append("-");
            }
            return sb.reverse().toString();
        }
    }
// @lc code=end
}
