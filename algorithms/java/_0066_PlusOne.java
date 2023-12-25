/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.cn/problems/plus-one/description/
 *
 * algorithms
 * Easy (45.21%)
 * Likes:    1301
 * Dislikes: 0
 * Total Accepted:    670.1K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,3]'
 *
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the i^th digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large
 * integer does not contain any leading 0's.
 * 
 * Increment the large integer by one and return the resulting array of
 * digits.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 * 
 * 
 */

public class _0066_PlusOne {
// @lc code=start
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 0;
            int n = digits.length - 1;
            int value = digits[n] + 1 + carry;
            digits[n] = value % 10;
            carry = value / 10;
            if (carry == 0){
                return digits;
            }
            n--;
            while (n >= 0){
                value = digits[n] + carry;
                digits[n] = value % 10;
                carry = value / 10;
                n--;
            }
            if (carry != 0){
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                return newDigits;
            }
            return digits;
        }
    }
// @lc code=end
}

