package _020_ValidParentheses

/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (43.90%)
 * Likes:    4347
 * Dislikes: 0
 * Total Accepted:    1.7M
 * Total Submissions: 3.9M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "()"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 *
 *
 */

// @lc code=start
func isValid(s string) bool {
	stack := make([]int32, 0)
	for _, value := range s {
		if isOpen(value) {
			stack = append(stack, value)
		} else {
			if len(stack) == 0 {
				return false
			}
			open := stack[len(stack)-1]
			if !match(open, value) {
				return false
			}
			stack = stack[0 : len(stack)-1]
		}
	}
	return len(stack) == 0
}

func isOpen(open int32) bool {
	return open == '[' || open == '{' || open == '('
}

func match(open int32, close int32) bool {
	switch close {
	case ']':
		return open == '['
	case '}':
		return open == '{'
	case ')':
		return open == '('
	}
	return false
}

// @lc code=end
