/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.cn/problems/reverse-integer/description/
 *
 * algorithms
 * Medium (35.40%)
 * Likes:    3885
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 3.5M
 * Testcase Example:  '123'
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed
 * or unsigned).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: x = 120
 * Output: 21
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0007_ReverseInteger {
// @lc code=start
    class Solution {
        public int reverse(int x) {
            // 前导0问题
            // 例如1000 -> 1 , 但1002 -> 2001
            // 如果反转后超过阈值，返回0
            //去除反转0
            while(x % 10 == 0 && x != 0){
                x /= 10;
            }
            int result = 0;
            while(x != 0){
                int tmp = result;
                result = result * 10 + x % 10;
                x = x / 10;
                if (result / 10 != tmp) return 0;
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int x = 120;
        Assert.assertEquals(21, solution.reverse(x));
    }
}

