/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (43.16%)
 * Likes:    2230
 * Dislikes: 0
 * Total Accepted:    430.4K
 * Total Submissions: 997.2K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 */

public class _0152_MaximumProductSubarray {
// @lc code=start
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;
            int result = nums[0];
            int maxResult = nums[0];
            int minResult = nums[0];
            for (int i = 1; i < nums.length; i++){
                if (nums[i] < 0){
                    int t = maxResult;
                    maxResult = minResult;
                    minResult = t;
                }
                maxResult = Math.max(maxResult * nums[i], nums[i]);
                minResult = Math.min(minResult * nums[i], nums[i]);
                result = Math.max(result, maxResult);
            }
            return result;
        }
    }
// @lc code=end
}

