/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.cn/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (63.80%)
 * Likes:    2017
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.7M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you minimize the total number of operations done?
 */

import org.junit.Assert;
import org.junit.Test;

public class _0283_MoveZeroes{
// @lc code=start
    class Solution {
        public void moveZeroes(int[] nums) {
            int leftPointer = 0;
            for(int rightPointer = 0; rightPointer < nums.length; rightPointer++){
                if(nums[rightPointer] != 0){
                    swap(nums, leftPointer, rightPointer);
                    leftPointer++;
                }
            }
        }

        private void swap(int[] nums, int left, int right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
// @lc code=end
    @Test
    public void testMoveZeroes() {
        Solution solution = new Solution();

        // Test case 1: Move single zero to end
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] expected1 = {1, 3, 12, 0, 0};
        solution.moveZeroes(nums1);
        Assert.assertArrayEquals(expected1, nums1);

        // Test case 2: Move multiple zeros to end
        int[] nums2 = {0, 0, 1, 0, 3, 0, 12};
        int[] expected2 = {1, 3, 12, 0, 0, 0, 0};
        solution.moveZeroes(nums2);
        Assert.assertArrayEquals(expected2, nums2);

        // Test case 3: No zeros in array
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] expected3 = {1, 2, 3, 4, 5};
        solution.moveZeroes(nums3);
        Assert.assertArrayEquals(expected3, nums3);

        // Test case 4: All zeros in array
        int[] nums4 = {0, 0, 0, 0, 0};
        int[] expected4 = {0, 0, 0, 0, 0};
        solution.moveZeroes(nums4);
        Assert.assertArrayEquals(expected4, nums4);

        // Test case 5: Array with only one element
        int[] nums5 = {1};
        int[] expected5 = {1};
        solution.moveZeroes(nums5);
        Assert.assertArrayEquals(expected5, nums5);
    }
}

