package _022_GenerateParentheses

/*
 * @lc app=leetcode.cn id=22 lang=golang
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.59%)
 * Likes:    3518
 * Dislikes: 0
 * Total Accepted:    792.2K
 * Total Submissions: 1M
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 8
 *
 *
 */

// @lc code=start
func generateParenthesis(n int) []string {
	result := make([]string, 0)
	backtrace(n, 0, 0, "", &result)
	return result
}

func backtrace(n int, open int, close int, cur string, result *[]string) {
	if open == n && close == n {
		*result = append(*result, cur)
		return
	}
	if open < n {
		backtrace(n, open+1, close, cur+"(", result)
	}
	if open > close {
		backtrace(n, open, close+1, cur+")", result)
	}
}

// @lc code=end
