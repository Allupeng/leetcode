package leetcode

/*
 * @lc app=leetcode id=34 lang=golang
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (43.75%)
 * Likes:    19823
 * Dislikes: 481
 * Total Accepted:    1.9M
 * Total Submissions: 4.3M
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
func searchRange(nums []int, target int) []int {
	first, last := findPositionOfElementsIndex(nums, target, true), findPositionOfElementsIndex(nums, target, false)
	return []int{first, last}
}

func findPositionOfElementsIndex(nums []int, target int, findFirst bool) int {
	index := -1
	lo, hi := 0, len(nums)-1
	for lo <= hi {
		mid := lo + (hi-lo)>>1
		if target < nums[mid] {
			hi = mid - 1
		} else if target > nums[mid] {
			lo = mid + 1
		} else {
			index = mid
			if findFirst {
				hi = mid - 1
			} else {
				lo = mid + 1
			}
		}
	}
	return index
}

// @lc code=end
