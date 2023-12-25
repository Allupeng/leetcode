/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] Monotone Increasing Digits
 *
 * https://leetcode.cn/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (50.34%)
 * Likes:    390
 * Dislikes: 0
 * Total Accepted:    94K
 * Total Submissions: 186.8K
 * Testcase Example:  '10'
 *
 * An integer has monotone increasing digits if and only if each pair of
 * adjacent digits x and y satisfy x <= y.
 * 
 * Given an integer n, return the largest number that is less than or equal to
 * n with monotone increasing digits.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 10
 * Output: 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1234
 * Output: 1234
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 332
 * Output: 299
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^9
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0738_MonotoneIncreasingDigits {
// @lc code=start
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            int[] digits = splitN(n);
            // 3 2 2 -> 3 1 9 -> 299
            for (int i = digits.length - 1; i > 0; i--){
                if (digits[i] > digits[i - 1]){
                    digits[i - 1]--;
                    digits[i] = 9;
                }
            }
            return buildN(digits);
        }

        private int buildN(int[] digits){
            if (digits.length == 1){
                return digits[0];
            }
            int digit = digits[digits.length - 1];
            int time = 10;
            for (int i = digits.length - 2; i >= 0; i--){
                digit += time * digits[i];
                time *= 10;
            }
            return digit;
        }

        private int[] splitN(int n){
            List<Integer> digits = new ArrayList<>();
            while(n != 0){
                digits.add(n % 10);
                n = n / 10;
            }
            int[] digitsArray = new int[digits.size()];
            for (int i = digits.size() - 1; i >= 0; i--){
                digitsArray[i] = digits.get(i);
            }
            return digitsArray;
        }
    }
// @lc code=end
}

