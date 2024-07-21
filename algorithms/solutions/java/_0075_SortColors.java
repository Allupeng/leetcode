/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.cn/problems/sort-colors/description/
 *
 * algorithms
 * Medium (61.16%)
 * Likes:    1773
 * Dislikes: 0
 * Total Accepted:    629.4K
 * Total Submissions: 1M
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 * 
 * 
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 * 
 */

public class _0075_SortColors {
// @lc code=start
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0, right = nums.length - 1;
            int cur = 0;
            while (cur <= right){
                if (nums[cur] == 2){
                    swap(nums, cur, right);
                    right--;
                }else if (nums[cur] == 0){
                    swap(nums, cur, left);
                    left++;
                    cur++;
                }else{
                    cur++;
                }
            }
        }

        private void swap(int[] nums, int left, int right){
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
        }
    }
// @lc code=end
}

