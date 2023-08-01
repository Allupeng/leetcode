/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (52.17%)
 * Likes:    1827
 * Dislikes: 0
 * Total Accepted:    433.1K
 * Total Submissions: 830.2K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given an integer array nums, return true if you can partition the array into
 * two subsets such that the sum of the elements in both subsets is equal or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0416_PartitionEqualSubsetSum {
// @lc code=start
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1){
                // can't be partition
                return false;
            }
            /**
             * 0-1背包问题
             * 数组中每个元素都是一个物品
             * 每个物品的价值为nums[i]
             * 题目要求为能否在数组中找到价值 = sum / 2的物品数量
             */
            // dp 定义为 dp[i][j] 为 在arr[0...i]的物品当中容量为j
            // 本题目求解为 当容量为 sum / 2时能否价值恰好等于 sum / 2
            int target = sum / 2;
            int[][] dp = new int[nums.length][target + 1];

            for (int j = 0; j <= target; j++){
                if (j >= nums[0]){
                    dp[0][j] = nums[0];
                }
            }
            for (int i = 0; i < nums.length; i++){
                dp[i][0] = 0;
            }

            for (int i = 1; i < nums.length; i++){
                for (int j = 1; j <= target; j++){
                    if (j < nums[i]){
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        // 要么不装，即价值等于上一个
                        dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
                    }
                }
            }
            return dp[nums.length - 1][target] == target;
        }
    }
// @lc code=end

    @Test
    public void test1(){
        int[] array = new int[]{9,1,2,4,10};
        Solution solution = new Solution();
        Assert.assertTrue(solution.canPartition(array));
    }

    @Test
    public void test2(){
        int[] array = new int[]{1,5,10,6};
        Solution solution = new Solution();
        Assert.assertTrue(solution.canPartition(array));
    }
}

