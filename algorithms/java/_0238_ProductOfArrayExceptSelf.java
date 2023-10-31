/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.cn/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (74.90%)
 * Likes:    1624
 * Dislikes: 0
 * Total Accepted:    332.5K
 * Total Submissions: 443.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 * 
 */

import org.junit.Test;

public class _0238_ProductOfArrayExceptSelf {
// @lc code=start
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] R = new int[nums.length], L = new int[nums.length];
            L[0] = 1;
            for(int i = 1; i < nums.length; i++){
                L[i] = L[i - 1] * nums[i - 1];
            }
            R[nums.length - 1] = 1;
            for (int i = nums.length - 2; i >= 0; i--){
                R[i] = R[i + 1] * nums[i + 1];
            }
            for (int i = 0; i < nums.length; i++){
                nums[i] = L[i] * R[i];
            }
            return nums;
        }
    }
// @lc code=end
    @Test
    public void test(){
        int[] ints = new int[]{1, 2, 3, 4};
        Solution solution = new Solution();
        solution.productExceptSelf(ints);
    }
}

