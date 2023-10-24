/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.cn/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (45.02%)
 * Likes:    2025
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
public class _0035_SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;
            while (lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                if(target == nums[mid]){
                    return mid;
                }else if(target < nums[mid]){
                    hi = mid - 1;
                }else if(nums[mid] < target){
                    lo = mid + 1;
                }
            }
            return hi + 1;
        }
    }
}
// @lc code=end

