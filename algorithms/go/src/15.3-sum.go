/*
 * @lc app=leetcode id=15 lang=golang
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (30.99%)
 * Likes:    17269
 * Dislikes: 1662
 * Total Accepted:    1.9M
 * Total Submissions: 6.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 *
 */

// @lc code=start
// package src

// import "sort"

func threeSum(nums []int) [][]int {
	res := [][]int{}
	val_count := map[int]int{}
	for _, val := range nums {
		val_count[val]++
	}
	uniqueNums := []int{}
	for val := range val_count {
		uniqueNums = append(uniqueNums, val)
	}
	sort.Ints(uniqueNums)
	for i := 0; i < len(uniqueNums); i++ {
		if uniqueNums[i]*3 == 0 && val_count[uniqueNums[i]] >= 3 {
			res = append(res, []int{uniqueNums[i], uniqueNums[i], uniqueNums[i]})
		}
		for j := i + 1; j < len(uniqueNums); j++ {
			if uniqueNums[i]*2+uniqueNums[j] == 0 && val_count[uniqueNums[i]] >= 2 {
				res = append(res, []int{uniqueNums[i], uniqueNums[i], uniqueNums[j]})
			}
			if uniqueNums[j]*2+uniqueNums[i] == 0 && val_count[uniqueNums[j]] >= 2 {
				res = append(res, []int{uniqueNums[i], uniqueNums[j], uniqueNums[j]})
			}
			c := 0 - (uniqueNums[i] + uniqueNums[j])
			if c > uniqueNums[j] && val_count[c] > 0 {
				res = append(res, []int{uniqueNums[i], uniqueNums[j], c})
			}
		}
	}
	return res
}

// @lc code=end
