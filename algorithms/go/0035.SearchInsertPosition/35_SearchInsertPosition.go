package _035_SearchInsertPosition

/*
 * @lc app=leetcode id=35 lang=golang
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (45.25%)
 * Likes:    15537
 * Dislikes: 688
 * Total Accepted:    2.7M
 * Total Submissions: 5.9M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
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
func searchInsert(nums []int, target int) int {
	lo, hi := 0, len(nums)-1
	for lo <= hi {
		mid := lo + ((hi - lo) >> 1)
		if target == nums[mid] {
			return mid
		} else if target < nums[mid] {
			hi = mid - 1
		} else {
			lo = mid + 1
		}
	}
	return lo
}

// @lc code=end
