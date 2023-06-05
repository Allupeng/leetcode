/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (46.82%)
 * Likes:    1726
 * Dislikes: 0
 * Total Accepted:    549K
 * Total Submissions: 1.2M
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal
 * to target. If there is no such subarray, return 0 instead.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _0209_MinimumSizeSubarraySum{
// @lc code=start
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0;
            int minLen = Integer.MAX_VALUE;
            int curSum = 0;
            while(right < nums.length){
                curSum += nums[right];
                while(curSum >= target && left <= right){
                    int len = right - left + 1;
                    if(len < minLen){
                        minLen = len;
                    }
                    curSum -= nums[left];
                    left++;
                }
                right++;
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
// @lc code=end
    @Test
    public void testMinSubArrayLen() {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2,3,1,2,4,3};
        int target1 = 7;
        int expected1 = 2;
        int actual1 = solution.minSubArrayLen(target1, nums1);
        assertEquals(expected1, actual1);

        // Test case 2
        int[] nums2 = {1,4,4};
        int target2 = 4;
        int expected2 = 1;
        int actual2 = solution.minSubArrayLen(target2, nums2);
        assertEquals(expected2, actual2);

        // Test case 3
        int[] nums3 = {1,1,1,1,1,1,1,1};
        int target3 = 11;
        int expected3 = 0;
        int actual3 = solution.minSubArrayLen(target3, nums3);
        assertEquals(expected3, actual3);

        // Test case 4
        int[] nums4 = {1,2,3,4,5};
        int target4 = 11;
        int expected4 = 3;
        int actual4 = solution.minSubArrayLen(target4, nums4);
        assertEquals(expected4, actual4);

        // Test case 5
        int[] nums5 = {1,1,1,1,1,1,1,1};
        int target5 = 8;
        int expected5 = 8;
        int actual5 = solution.minSubArrayLen(target5, nums5);
        assertEquals(expected5, actual5);

        // Test case 6
        int[] nums6 = {1,1,1,1,1,1,1,1};
        int target6 = 1;
        int expected6 = 1;
        int actual6 = solution.minSubArrayLen(target6, nums6);
        assertEquals(expected6, actual6);

        // Test case 7
        int[] nums7 = {1,1,1,1,1,1,1,1};
        int target7 = 9;
        int expected7 = 0;
        int actual7 = solution.minSubArrayLen(target7, nums7);
        assertEquals(expected7, actual7);

        // Test case 8
        int[] nums8 = {1,1,1,1,1,1,1,1};
        int target8 = 10;
        int expected8 = 0;
        int actual8 = solution.minSubArrayLen(target8, nums8);
        assertEquals(expected8, actual8);
    }
}

