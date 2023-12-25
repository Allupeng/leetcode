/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * algorithms
 * Medium (54.79%)
 * Likes:    6149
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 2.6M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 */

public class _0053_MaximumSubarray {
// @lc code=start
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0){
                return 0;
            }
            //dp[j] 代表以j结尾的nums[0...j]的最大子序和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int result = nums[0];
            for (int i = 1; i < nums.length; i++){
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
// @lc code=end

    // 贪心算法
    private int maxSubArrayByGreedyAlgorithm(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int maxSubArray = nums[0];
        int curValue = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (curValue < 0){
                curValue = nums[i];
            }else {
                curValue += nums[i];
            }
            maxSubArray = Math.max(maxSubArray, curValue);
        }
        return maxSubArray;
    }
}

