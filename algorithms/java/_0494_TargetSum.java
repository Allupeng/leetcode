/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.cn/problems/target-sum/description/
 *
 * algorithms
 * Medium (48.59%)
 * Likes:    1696
 * Dislikes: 0
 * Total Accepted:    366.6K
 * Total Submissions: 754.5K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the
 * integers.
 * 
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 * 
 * 
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be
 * target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], target = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0494_TargetSum {
// @lc code=start
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // left - right = target -> right = left - target
            // left + right = sum
            // left = (sum + target) / 2
            int sum = Arrays.stream(nums).sum();
            if (((sum + target) % 2 == 1) || (Math.abs(target) > sum)){
                return 0;
            }
            int left = (sum + target) / 2;
            // dp[j]的定义为 有dp[j]个方法能够计算出j
            int[] dp = new int[left + 1];
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++){
                for (int j = left; j >= nums[i]; j--){
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
            return dp[left];
        }
    }
// @lc code=end

    @Test
    public void test1(){
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.findTargetSumWays(nums, target));
    }
}

