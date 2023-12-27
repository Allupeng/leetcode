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
        left = right = 0
        max_len = 0
        dp = [[False for _ in range(len(s))] for _ in range(len(s))]
        for i in range(len(s)):
            dp[i][i] = True
        for i in range(len(s) - 2, -1, -1):
            for j in range(1, len(s)):
                if s[i] == s[j] and (j - i == 1 or dp[i + 1][j - 1]):
                    dp[i][j] = True
                if dp[i][j] and j - i + 1 > max_len:
                    max_len = j - i + 1
                    left = i
                    right = j
        return s[left: right + 1]
        
    
# @lc code=end

