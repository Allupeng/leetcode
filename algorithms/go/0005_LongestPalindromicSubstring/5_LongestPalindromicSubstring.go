package _005_LongestPalindromicSubstring

/*
 * @lc app=leetcode.cn id=5 lang=golang
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (38.04%)
 * Likes:    7065
 * Dislikes: 0
 * Total Accepted:    1.6M
 * Total Submissions: 4.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 *
 */

// @lc code=start
func longestPalindrome(s string) string {
	// dp[i][j] = true 代表s[i:j] 为回文子串
	// dp[i][j] = true if dp[i+1][j-1] = true && s[i] == s[j]
	// i + 1 -> i && j - 1 > j
	if len(s) <= 1 {
		return s
	}
	dp := make([][]bool, len(s))
	maxLen := 1
	left := 0
	for i := range dp {
		dp[i] = make([]bool, len(s))
	}
	for i := 0; i < len(s); i++ {
		dp[i][i] = true
	}
	for i := len(s) - 1; i >= 0; i-- {
		for j := i + 1; j < len(s); j++ {
			if s[i] == s[j] && (i+1 == j || dp[i+1][j-1]) {
				dp[i][j] = true
				if j-i+1 > maxLen {
					maxLen = j - i + 1
					left = i
				}
			}
		}
	}
	return s[left : left+maxLen]
}

// @lc code=end
