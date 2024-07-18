/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (43.36%)
 * Likes:    2676
 * Dislikes: 0
 * Total Accepted:    975.6K
 * Total Submissions: 2.2M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
// @lc code=start
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return new int[]{findFirstPositionOfElementInSortedArray(nums, target)
                    , findLastPositionOfElementInSortedArray(nums, target)};
        }

        private int findFirstPositionOfElementInSortedArray(int[] nums, int target){
            int left = 0, right = nums.length - 1;
            while (left <= right){
                int mid = left + ((right - left) >> 1);
                if (target == nums[mid]){
                    if (mid == 0 || nums[mid] != nums[mid - 1]){
                        return mid;
                    }else{
                        right = mid - 1;
                    }
                }else if (target < nums[mid]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int findLastPositionOfElementInSortedArray(int[] nums, int target){
            int left = 0, right = nums.length - 1;
            while (left <= right){
                int mid = left + ((right - left) >> 1);
                if (target == nums[mid]){
                    if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                        return mid;
                    }else{
                        left = mid + 1;
                    }
                }else if (target < nums[mid]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
// @lc code=end
}

