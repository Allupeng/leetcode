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
            if(nums.length < 2) return false;
            int sum = Arrays.stream(nums).sum();
            if(sum % 2 == 1) return false;
            int target = sum / 2;
            int[][] dp = new int[nums.length][target + 1];
            for(int j = 0; j <= target; j++){
                if(j >= nums[0]){
                    dp[0][j] = nums[0];
                }
            }
            for(int i = 0; i < nums.length; i++){
                dp[i][0] = 0;
            }
            for(int i = 1; i < nums.length; i++){
                for(int j = 1; j <= target; j++){
                    if(j >= nums[i]){
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    }else{
                        dp[i][j] = dp[i - 1][j];
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

