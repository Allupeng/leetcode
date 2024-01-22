package _351_CountNegativeNumbersInASortedMatrix

/*
 * @lc app=leetcode id=1351 lang=golang
 *
 * [1351] Count Negative Numbers in a Sorted Matrix
 *
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
 *
 * algorithms
 * Easy (77.21%)
 * Likes:    4840
 * Dislikes: 129
 * Total Accepted:    386.2K
 * Total Submissions: 500.2K
 * Testcase Example:  '[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]'
 *
 * Given a m x n matrix grid which is sorted in non-increasing order both
 * row-wise and column-wise, return the number of negative numbers in grid.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 *
 *
 * Follow up: Could you find an O(n + m) solution?
 */

// @lc code=start
func countNegatives(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	row, col := 0, n-1
	cnt := 0
	for row < m && col >= 0 {
		cur := grid[row][col]
		if cur < 0 {
			cnt += m - row
			col--
		} else {
			row++
		}
	}
	return cnt
}

// @lc code=end
