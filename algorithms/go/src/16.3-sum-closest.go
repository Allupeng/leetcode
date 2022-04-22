/*
 * @lc app=leetcode id=16 lang=golang
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (47.07%)
 * Likes:    5687
 * Dislikes: 242
 * Total Accepted:    786.4K
 * Total Submissions: 1.7M
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an integer array nums of length n and an integer target, find three
 * integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 *
 *
 */

// @lc code=start

// package src

// import (
// 	"math"
// 	"sort"
// )

func threeSumClosest(nums []int, target int) int {
	n, result, diff := len(nums), 0, math.MaxInt32
	if n > 2 {
		//sort the array
		sort.Ints(nums)
		for i := 0; i < n-2; i++ {
			for j, k := i+1, n-1; j < k; {
				sum := nums[i] + nums[j] + nums[k]
				if abs(sum-target) < diff {
					result, diff = sum, abs(sum-target)
				}
				if sum == target {
					return result
				} else if sum < target {
					j++
				} else {
					k--
				}
			}
		}
	}
	return result
}

func abs(a int) int {
	if a > 0 {
		return a
	} else {
		return -a
	}
}

// @lc code=end
