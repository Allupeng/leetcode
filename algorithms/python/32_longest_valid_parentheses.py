#
# @lc app=leetcode id=32 lang=python3
#
# [32] Longest Valid Parentheses
#
# https://leetcode.com/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (33.49%)
# Likes:    11973
# Dislikes: 378
# Total Accepted:    683K
# Total Submissions: 2M
# Testcase Example:  '"(()"'
#
# Given a string containing just the characters '(' and ')', return the length
# of the longest valid (well-formed) parentheses substring.
# 
# 
# Example 1:
# 
# 
# Input: s = "(()"
# Output: 2
# Explanation: The longest valid parentheses substring is "()".
# 
# 
# Example 2:
# 
# 
# Input: s = ")()())"
# Output: 4
# Explanation: The longest valid parentheses substring is "()()".
# 
# 
# Example 3:
# 
# 
# Input: s = ""
# Output: 0
# 
# 
# 
# Constraints:
# 
# 
# 0 <= s.length <= 3 * 10^4
# s[i] is '(', or ')'.
# 
# 
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s or len(s) == 1:
            return 0
        if len(s) == 2:
            return 2 if s[0] == '(' and s[1] == ')' else 0
        dp = [0] * (len(s))
        for i in range(len(s)):
            if(s[i] == '('):
                dp[i] = 0
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i - 1] == '(':
                    if i <= 1:
                        dp[i] = 2
                    else:
                        dp[i] = 2 + dp[i - 2]
                else:
                    if dp[i - 1] > 0:
                        pre = i - 1 - dp[i - 1]
                        if pre >= 0 and s[pre] == '(':
                            if pre - 1 > 0:
                                dp[i] = dp[pre - 1] + dp[i - 1] + 2
                            else:
                                dp[i] = dp[i - 1] + 2
        max_len = dp[0]
        for i in range(1, len(dp)):
            max_len = max(max_len, dp[i])
        return max_len
        
# @lc code=end

