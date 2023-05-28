/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.cn/problems/sqrtx/description/
 *
 * algorithms
 * Easy (38.46%)
 * Likes:    1339
 * Dislikes: 0
 * Total Accepted:    738.6K
 * Total Submissions: 1.9M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * 
 * 
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down
 * to the nearest integer, 2 is returned.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
public class _0069_SqrtX{
        class Solution {
        public int mySqrt(int x) {
            if (x == 0){
                return 0;
            }
            int lo = 1;
            int hi = x;
            while (lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                if((mid <= x / mid) && ((x / (mid + 1))< mid + 1) ){
                    return mid;
                }else if(mid < x / mid){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
            return 0;
        }
    }
}
// @lc code=end

