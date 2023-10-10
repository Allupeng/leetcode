/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] Add Strings
 *
 * https://leetcode.cn/problems/add-strings/description/
 *
 * algorithms
 * Easy (54.70%)
 * Likes:    796
 * Dislikes: 0
 * Total Accepted:    303.2K
 * Total Submissions: 554.4K
 * Testcase Example:  '"11"\n"123"'
 *
 * Given two non-negative integers, num1 and num2 represented as string, return
 * the sum of num1 and num2 as a string.
 * 
 * You must solve the problem without using any built-in library for handling
 * large integers (such as BigInteger). You must also not convert the inputs to
 * integers directly.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num1.length, num2.length <= 10^4
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0415_AddStrings {
// @lc code=start
    class Solution {
        public String addStrings(String num1, String num2) {
            // 类似于链表的两数相加
            StringBuilder result = new StringBuilder();
            int i = num1.length() - 1, j = num2.length() - 1;
            int carry = 0, value = 0;
            while (i >= 0 || j >= 0){
                int ch1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int ch2 = j < 0 ? 0 : num2.charAt(j) - '0';
                value = (ch1 + ch2 + carry) % 10;
                carry = (ch1 + ch2 + carry) / 10;
                result.append(value);
                i--;
                j--;
            }
            if (carry != 0){
                result.append(carry);
            }
            return result.reverse().toString();
        }
    }
// @lc code=end

    @Test
    public void test(){
        String num1 = "123", num2 = "456";
        Solution solution = new Solution();
        Assert.assertEquals("579", solution.addStrings(num1, num2));
    }

    @Test
    public void test01(){
        String num1 = "456", num2 = "77";
        Solution solution = new Solution();
        Assert.assertEquals("533", solution.addStrings(num1, num2));
    }
}

