/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 *
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/
 *
 * algorithms
 * Easy (55.81%)
 * Likes:    405
 * Dislikes: 0
 * Total Accepted:    202.5K
 * Total Submissions: 362.8K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * continuous increasing subsequence (i.e. subarray). The subsequence must be
 * strictly increasing.
 * 
 * A continuous increasing subsequence is defined by two indices l and r (l <
 * r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for
 * each l <= i < r, nums[i] < nums[i + 1].
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with
 * length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as
 * elements 5 and 7 are separated by element
 * 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2] with
 * length 1. Note that it must be strictly
 * increasing.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

import java.util.Arrays;

public class _0674_LongestContinuousIncreasingSubsequence {
// @lc code=start
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            // dp[j]代表 nums[0...j]时的最长连续递增序列长度
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int result = 1;
            for (int i = 1; i < nums.length; i++){
                if (nums[i] > nums[i - 1]){
                    dp[i] = dp[i - 1] + 1;
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
// @lc code=end
}

