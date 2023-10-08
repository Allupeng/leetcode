/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] Add Digits
 *
 * https://leetcode.cn/problems/add-digits/description/
 *
 * algorithms
 * Easy (70.79%)
 * Likes:    634
 * Dislikes: 0
 * Total Accepted:    175.1K
 * Total Submissions: 247.3K
 * Testcase Example:  '38'
 *
 * Given an integer num, repeatedly add all its digits until the result has
 * only one digit, and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2 
 * Since 2 has only one digit, return it.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= num <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 */

public class _0258_AddDigits {
// @lc code=start
    class Solution {
        public int addDigits(int num) {
            // find the last times * 9
            return num - 9 * ((num - 1) / 9);
        }
    }
// @lc code=end
}

