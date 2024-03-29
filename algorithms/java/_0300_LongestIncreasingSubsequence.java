/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (54.89%)
 * Likes:    3316
 * Dislikes: 0
 * Total Accepted:    767.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 * 
 */

import java.util.Arrays;

public class _0300_LongestIncreasingSubsequence {
// @lc code=start
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0) return 0;
            if(nums.length == 1) return 1;
            int n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int result = 0;
            for(int j = 1; j < n; j++){
                for(int i = 0; i < j; i++){
                    if(nums[j] > nums[i]){
                        dp[j] = Math.max(dp[i] + 1, dp[j]);
                    }
                }
                result = Math.max(result, dp[j]);
            }
            return result;
        }
    }
// @lc code=end
}

