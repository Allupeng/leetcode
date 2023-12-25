/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (43.13%)
 * Likes:    2129
 * Dislikes: 0
 * Total Accepted:    386.7K
 * Total Submissions: 896.6K
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

import org.junit.Assert;
import org.junit.Test;

public class _0152_MaximumProductSubarray {
// @lc code=start
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;
            int[] maxDP = new int[nums.length];
            int[] minDP = new int[nums.length];
            for (int i = 0; i < nums.length; i++){
                maxDP[i] = nums[i];
                minDP[i] = nums[i];
            }
            for (int i = 1; i < nums.length; i++){
                maxDP[i] = Math.max(maxDP[i - 1] * nums[i], Math.max(minDP[i - 1] * nums[i], nums[i]));
                minDP[i] = Math.min(maxDP[i - 1] * nums[i], Math.min(minDP[i - 1] * nums[i], nums[i]));
            }
            int ans = maxDP[0];
            for (int i = 1; i < maxDP.length; i++){
                ans = Math.max(ans, maxDP[i]);
            }
            return ans;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] nums = new int[]{-2,3,-4};
        Assert.assertEquals(24, solution.maxProduct(nums));
    }
}

