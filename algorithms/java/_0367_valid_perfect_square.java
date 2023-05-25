/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] Valid Perfect Square
 *
 * https://leetcode.cn/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (44.79%)
 * Likes:    498
 * Dislikes: 0
 * Total Accepted:    224.2K
 * Total Submissions: 500.7K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, return true if num is a perfect square or
 * false otherwise.
 * 
 * A perfect square is an integer that is the square of an integer. In other
 * words, it is the product of some integer with itself.
 * 
 * You must not use any built-in library function, such as sqrt.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an
 * integer.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= num <= 2^31 - 1
 * 
 * 
 */

public class _0367_valid_perfect_square{
// @lc code=start
    class Solution {
        public boolean isPerfectSquare(int num) {
            if(num == 0){
                return true;
            }
            int lo = 1;
            int hi = num;
            while(lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                long square = (long) mid * mid;
                if(square > num){
                    hi = mid - 1;
                }else if(square < num){
                    lo = mid + 1;
                }else{
                    return true;
                }
            }
            return false;
        }
    }
// @lc code=end
}

