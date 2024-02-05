package _287_FindTheDuplicateNumber

/*
 * @lc app=leetcode id=287 lang=golang
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (59.40%)
 * Likes:    22239
 * Dislikes: 4053
 * Total Accepted:    1.5M
 * Total Submissions: 2.5M
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only
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

// @lc code=start
func findDuplicate(nums []int) int {
	/**
	 * 1 <= n <= 10^5
	 * nums.length == n + 1
	 * 1 <= nums[i] <= n
	 */
	lo, hi := 1, len(nums)-1
	for lo < hi {
		mid := lo + ((hi - lo) >> 1)
		if count(nums, mid) <= mid {
			lo = mid + 1
		} else {
			hi = mid
		}
	}
	return lo
}

/*
*
count the numbers of elements which is small and equals than e
*/
func count(nums []int, e int) int {
	cnt := 0
	for _, value := range nums {
		if value <= e {
			cnt++
		}
	}
	return cnt
}

// @lc code=end
