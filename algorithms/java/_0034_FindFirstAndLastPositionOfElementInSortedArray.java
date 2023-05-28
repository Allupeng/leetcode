/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (42.36%)
 * Likes:    2310
 * Dislikes: 0
 * Total Accepted:    792.1K
 * Total Submissions: 1.9M
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

// @lc code=start
public class _0034_FindFirstAndLastPositionOfElementInSortedArray{
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            int firstPos = findFirstPosition(lo, hi, target, nums);
            int lastPos = findLastPosition(lo, hi, target, nums);
            return new int[]{firstPos, lastPos};
        }

        private int findFirstPosition(int lo, int hi, int target, int[] nums){
            if(lo > hi){
                return -1;
            }
            while(lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                if(target < nums[mid]){
                    hi = mid - 1;
                }else if(target > nums[mid]){
                    lo = mid + 1;
                }else{
                    if(mid == 0 || nums[mid - 1] != nums[mid]){
                        return mid;
                    }else{
                        hi = mid - 1;
                    }
                }
            }
            return -1;
        }

        private int findLastPosition(int lo, int hi, int target, int[] nums){
            if(lo > hi){
                return -1;
            }
            while(lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                if(target < nums[mid]){
                    hi = mid - 1;
                }else if(target > nums[mid]){
                    lo = mid + 1;
                }else{
                    if(mid == nums.length - 1 || nums[mid + 1] != nums[mid]){
                        return mid;
                    }else{
                        lo = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
// @lc code=end

