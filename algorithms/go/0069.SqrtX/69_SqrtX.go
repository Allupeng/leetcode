package _69_SqrtX

/*
 * @lc app=leetcode id=69 lang=golang
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (38.33%)
 * Likes:    7789
 * Dislikes: 4427
 * Total Accepted:    1.8M
 * Total Submissions: 4.7M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, return the square root of x rounded down to
 * the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is ±2, so we return 2.
 *
 *
 * Example 2:
 *
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down
 * to the nearest integer, 2 is returned.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= x <= 2^31 - 1
 *
 *
 */

// @lc code=start
func mySqrt(x int) int {
	lo, hi := 1, x
	for lo <= hi {
		mid := lo + (hi-lo)>>1
		target := mid * mid
		if target <= x && x < (mid+1)*(mid+1) {
			return mid
		} else if target < x {
			lo = mid + 1
		} else {
			hi = mid - 1
		}
	}
	return 0
}

// @lc code=end
