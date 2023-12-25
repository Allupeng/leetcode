/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.cn/problems/single-number/description/
 *
 * algorithms
 * Easy (72.49%)
 * Likes:    2954
 * Dislikes: 0
 * Total Accepted:    945.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers nums, every element appears twice except
 * for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 * 
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears
 * only once.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0136_SingleNumber {
// @lc code=start
    class Solution {
        public int singleNumber(int[] nums) {
            if (nums.length == 1){
                return nums[0];
            }
            int result = nums[0];
            for (int i = 1; i < nums.length; i++){
                result ^= nums[i];
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[] nums = new int[]{4,1,2,1,2};
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.singleNumber(nums));
    }
}

