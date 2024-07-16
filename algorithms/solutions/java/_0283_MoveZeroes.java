 /*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.cn/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (63.50%)
 * Likes:    2354
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 2.2M
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

public class _0283_MoveZeroes {
// @lc code=start
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0, right = 0;
            while(right < nums.length){
                if (nums[right] != 0) {
                    if (left != right) {
                        swap(nums, right, left);
                    }
                    left++;
                }
                right++;
            }
        }

        private void swap(int[] nums, int i, int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
// @lc code=end
}

