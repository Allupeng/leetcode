/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] Combination Sum IV
 *
 * https://leetcode.cn/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (52.83%)
 * Likes:    842
 * Dislikes: 0
 * Total Accepted:    151.7K
 * Total Submissions: 287.1K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The test cases are generated so that the answer can fit in a 32-bit
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [9], target = 3
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 * 
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _0377_CombinationSumIv {
// @lc code=start
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            //dp[j] 代表组成j的组合数
            //完全背包问题，nums中的元素可以重复计算
            int[] dp = new int[target + 1];
            dp[0] = 1;
            // 排列问题
            // (1, 1, 2) 和(2, 1, 1)是不同的结果
            for (int j = 0; j <= target; j++){
                for (int i = 0; i < nums.length; i++){
                    if (j - nums[i] < 0){
                        continue;
                    }
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }

            return dp[target];
        }
    }
// @lc code=end
    @Test
    public void testCombinationSum4WithValidInput() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;
        int expected = 7;
        int actual = solution.combinationSum4(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testCombinationSum4WithZeroTarget() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 0;
        int expected = 1;
        int actual = solution.combinationSum4(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testCombinationSum4WithZeroNums() {
        Solution solution = new Solution();
        int[] nums = {};
        int target = 5;
        int expected = 0;
        int actual = solution.combinationSum4(nums, target);
        assertEquals(expected, actual);
    }
}
