#
# @lc app=leetcode id=22 lang=python3
#
# [22] Generate Parentheses
#
# https://leetcode.com/problems/generate-parentheses/description/
#
# algorithms
# Medium (73.81%)
# Likes:    20190
# Dislikes: 851
# Total Accepted:    1.6M
# Total Submissions: 2.2M
# Testcase Example:  '3'
#
# Given n pairs of parentheses, write a function to generate all combinations
# of well-formed parentheses.
# 
# 
# Example 1:
# Input: n = 3
# Output: ["((()))","(()())","(())()","()(())","()()()"]
# Example 2:
# Input: n = 1
# Output: ["()"]
# 
# 
# Constraints:
# 
# 
# 1 <= n <= 8
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        result = []
        self.backtrace(n, 0, 0, "", result)
        return result
    
    # open record the left count, close record the right count
    def backtrace(self, n: int, open: int, close: int, cur: str, result: list):
        if open == n and close == n:
            result.append(cur)
            return
        if open < n:
            self.backtrace(n, open + 1, close, cur + "(", result)
        if open > close:
            self.backtrace(n, open, close + 1, cur + ")", result)
# @lc code=end

