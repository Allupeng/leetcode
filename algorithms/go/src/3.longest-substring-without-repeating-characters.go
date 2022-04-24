/*
 * @lc app=leetcode id=3 lang=golang
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.01%)
 * Likes:    23094
 * Dislikes: 1036
 * Total Accepted:    3.2M
 * Total Submissions: 9.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 */

// @lc code=start
// package src

func lengthOfLongestSubstring(s string) int {
	//滑动窗口思想,滑动窗口的右边界不断的向右扩展,如果有重复的字符,左边界向右扩展,缩小滑动窗口.
	//位图思想
	if len(s) == 0 {
		return 0
	}
	result, left, right := 0, 0, 0
	var bitSet [256]uint8
	for left < len(s) {
		if right < len(s) && bitSet[s[right]] != 1 {
			bitSet[s[right]] = 1
			right++
		} else {
			bitSet[s[left]] = 0
			left++
		}
		result = max(result, right-left)
	}
	return result
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

// @lc code=end
