/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (64.18%)
 * Likes:    2235
 * Dislikes: 0
 * Total Accepted:    333.6K
 * Total Submissions: 519.8K
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0287_FindTheDuplicateNumber {
// @lc code=start
    class Solution {
        public int findDuplicate(int[] nums) {
            int[] t = new int[100000 + 1];
            for (int n : nums){
                if (t[n] != 0){
                    return n;
                }else {
                    t[n] = 1;
                }
            }
            return -1;
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[] nums = new int[]{3,1,3,4,2};
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.findDuplicate(nums));
    }
}

