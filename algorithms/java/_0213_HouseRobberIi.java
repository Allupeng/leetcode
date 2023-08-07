/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (44.17%)
 * Likes:    1409
 * Dislikes: 0
 * Total Accepted:    351.7K
 * Total Submissions: 796.2K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it
 * will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2), because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0213_HouseRobberIi {
// @lc code=start
    class Solution {
        public int rob(int[] nums) {
            // 可以分为两部分问题
            // 从[1, n]中找出最大的抢劫金额
            // 从[0, n-1]中找出最大的抢劫金额
            if (nums.length == 0){
                return 0;
            }
            if (nums.length == 1){
                return nums[0];
            }
            if (nums.length == 2){
                return Math.max(nums[0], nums[1]);
            }
            int result1 = robInInterval(nums, 0, nums.length - 2);
            int result2 = robInInterval(nums, 1, nums.length - 1);
            return Math.max(result1, result2);
        }

        private int robInInterval(int[] nums, int start, int end){
            int[] dp = new int[end - start + 1];
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start + 1], nums[start]);
            for (int i = 2; i <= end - start; i++){
                dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
            }
            return dp[end - start];
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        Assert.assertEquals(3, solution.rob(nums));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 1};
        Assert.assertEquals(4, solution.rob(nums));
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 2};
        Assert.assertEquals(3, solution.rob(nums));
    }
}

