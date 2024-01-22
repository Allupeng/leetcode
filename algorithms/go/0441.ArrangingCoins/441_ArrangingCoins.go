package _441_ArrangingCoins

/*
 * @lc app=leetcode id=441 lang=golang
 *
 * [441] Arranging Coins
 *
 * https://leetcode.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (46.46%)
 * Likes:    3743
 * Dislikes: 1302
 * Total Accepted:    411.9K
 * Total Submissions: 886.6K
 * Testcase Example:  '5'
 *
 * You have n coins, and you want to build a staircase with these coins. The
 * staircase consists of k rows where the i^th row has exactly i coins. The
 * last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3^rd row is incomplete, we return 2.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4^th row is incomplete, we return 3.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 2^31 - 1
 *
 *
 */

// @lc code=start
func arrangeCoins(n int) int {
	stairCnt := 0
	i := 1
	for n/i != 0 {
		n -= i
		i++
		stairCnt++
	}
	return stairCnt
}

// @lc code=end
