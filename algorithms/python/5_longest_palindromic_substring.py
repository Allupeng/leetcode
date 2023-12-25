#
# @lc app=leetcode id=5 lang=python3
#
# [5] Longest Palindromic Substring
#
# https://leetcode.com/problems/longest-palindromic-substring/description/
#
# algorithms
# Medium (33.41%)
# Likes:    28256
# Dislikes: 1679
# Total Accepted:    2.8M
# Total Submissions: 8.4M
# Testcase Example:  '"babad"'
#
# Given a string s, return the longest palindromic substring in s.
# 
# 
# Example 1:
# 
# 
# Input: s = "babad"
# Output: "bab"
# Explanation: "aba" is also a valid answer.
# 
# 
# Example 2:
# 
# 
# Input: s = "cbbd"
# Output: "bb"
# 
# 
# 
# Constraints:
# 
# 
# 1 <= s.length <= 1000
# s consist of only digits and English letters.
# 
# 
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        right = left = 0
        # define dp[i][j] is a palidromic substring
        # when dp[i+1][j-1] is a palidromic substring
        # and dp[i] = dp[j]
        dp = [[False for _ in range(len(s))] for _ in range(len(s))]
        # initial the value of dp
        # dp[i][i] = True
        for i in range(len(dp)):
            dp[i][i] = True
        # record the index of max palidromic substring
        right = left = 0
        max_len = 1
        # dp[i][j] is calculate from dp[i+1][j-1], so we must calculate i + 1 to result i
        # and calculate j - 1 to result j 
        for i in range(len(dp) - 2, -1, -1):
            for j in range(1, len(dp[0])):
                # if i near j and s[i] = s[j] also true
                if s[i] == s[j] and (i + 1 == j or dp[i + 1][j - 1]):
                    dp[i][j] = True
                    if j - i + 1 > max_len:
                        left = i
                        right = j
                        max_len = j - i + 1
        return s[left : right + 1]
    
# @lc code=end

