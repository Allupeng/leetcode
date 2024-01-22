package _436_FindRightInterval

import "sort"

/*
 * @lc app=leetcode id=436 lang=golang
 *
 * [436] Find Right Interval
 *
 * https://leetcode.com/problems/find-right-interval/description/
 *
 * algorithms
 * Medium (51.71%)
 * Likes:    2059
 * Dislikes: 332
 * Total Accepted:    107K
 * Total Submissions: 206.8K
 * Testcase Example:  '[[1,2]]'
 *
 * You are given an array of intervals, where intervals[i] = [starti, endi] and
 * each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >=
 * endi and startj is minimized. Note that i may equal j.
 *
 * Return an array of right interval indices for each interval i. If no right
 * interval exists for interval i, then put -1 at index i.
 *
 *
 * Example 1:
 *
 *
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs
 * -1.
 *
 *
 * Example 2:
 *
 *
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start
 * that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start
 * that is >= end2 = 2.
 *
 *
 * Example 3:
 *
 *
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start
 * that is >= end1 = 3.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= intervals.length <= 2 * 10^4
 * intervals[i].length == 2
 * -10^6 <= starti <= endi <= 10^6
 * The start point of each interval is unique.
 *
 *
 */

// @lc code=start
func findRightInterval(intervals [][]int) []int {
	m, n := len(intervals), len(intervals[0])
	starts := make([][]int, m)
	for i := range starts {
		starts[i] = make([]int, n)
	}
	for i := range intervals {
		starts[i][0] = intervals[i][0]
		starts[i][1] = i
	}
	sort.Slice(starts, func(i, j int) bool {
		if starts[i][0] == starts[j][0] {
			return starts[i][1] < starts[j][1]
		}
		return starts[i][0] < starts[j][0]
	})
	res := make([]int, m)
	// mark end_i as target, find first start_j >= target using binary-search
	for i := range intervals {
		target := intervals[i][1]
		res[i] = findRightIndex(starts, target)
	}
	return res
}

func findRightIndex(starts [][]int, target int) int {
	lo, hi := 0, len(starts)-1
	for lo <= hi {
		mid := lo + (hi-lo)>>1
		if target <= starts[mid][0] {
			hi = mid - 1
		} else {
			lo = mid + 1
		}
	}
	if lo == len(starts) {
		return -1
	}
	return starts[lo][1]
}

// @lc code=end
