/*
 * @lc app=leetcode.cn id=1480 lang=java
 *
 * [1480] Running Sum of 1d Array
 *
 * https://leetcode.cn/problems/running-sum-of-1d-array/description/
 *
 * algorithms
 * Easy (76.36%)
 * Likes:    440
 * Dislikes: 0
 * Total Accepted:    329.8K
 * Total Submissions: 431.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] =
 * sum(nums[0]…nums[i]).
 * 
 * Return the running sum of nums.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1,
 * 1+1+1+1+1].
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 * 
 */

public class _1480_RunningSumOf1DArray {
// @lc code=start
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++){
                preSum[i] = preSum[i - 1] + nums[i];
            }
            return preSum;
        }
    }
// @lc code=end
}

