/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.cn/problems/happy-number/description/
 *
 * algorithms
 * Easy (63.31%)
 * Likes:    1322
 * Dislikes: 0
 * Total Accepted:    387.5K
 * Total Submissions: 612.1K
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * 
 * 
 * Return true if n is a happy number, and false if not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class _0202_HappyNumber {
// @lc code=start
    class Solution {
        public boolean isHappy(int n) {
            // if n < 0, n is not a happy number
            if (n < 0){
                return false;
            }
            Set<Integer> values = new HashSet<>();
            int happyNumber = calSum(n);
            while(!values.contains(happyNumber)){
                if (happyNumber == 1){
                    return true;
                }
                values.add(happyNumber);
                happyNumber = calSum(happyNumber);
            }
            return false;
        }

        private int calSum(int n){
            int result = 0;
            while(n != 0){
                int value = n % 10;
                result += value * value;
                n = n / 10;
            }
            return result;
        }
    }
// @lc code=end
}

