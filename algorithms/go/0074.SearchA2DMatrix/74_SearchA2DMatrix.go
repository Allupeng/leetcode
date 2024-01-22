package _074_SearchA2DMatrix

/*
 * @lc app=leetcode id=74 lang=golang
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (49.62%)
 * Likes:    15147
 * Dislikes: 402
 * Total Accepted:    1.6M
 * Total Submissions: 3.3M
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * You are given an m x n integer matrix with the following two
 * properties:
 *
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 *
 *
 * Given an integer target, return true if target is in matrix or false
 * otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 *
 *
 */

// @lc code=start
func searchMatrix(matrix [][]int, target int) bool {
	// start from top-right element
	m, n := len(matrix), len(matrix[0])
	row, col := 0, n-1
	for row < m && col >= 0 {
		cur := matrix[row][col]
		if target == cur {
			return true
		} else if target < cur {
			col--
		} else {
			row++
		}
	}
	return false
}

// @lc code=end
