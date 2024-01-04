#
# @lc app=leetcode.cn id=79 lang=python3
#
# [79] Word Search
#
# https://leetcode.cn/problems/word-search/description/
#
# algorithms
# Medium (46.55%)
# Likes:    1738
# Dislikes: 0
# Total Accepted:    476.7K
# Total Submissions: 1M
# Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
#
# Given an m x n grid of characters board and a string word, return true if
# word exists in the grid.
# 
# The word can be constructed from letters of sequentially adjacent cells,
# where adjacent cells are horizontally or vertically neighboring. The same
# letter cell may not be used more than once.
# 
# 
# Example 1:
# 
# 
# Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
# = "ABCCED"
# Output: true
# 
# 
# Example 2:
# 
# 
# Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
# = "SEE"
# Output: true
# 
# 
# Example 3:
# 
# 
# Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
# = "ABCB"
# Output: false
# 
# 
# 
# Constraints:
# 
# 
# m == board.length
# n = board[i].length
# 1 <= m, n <= 6
# 1 <= word.length <= 15
# board and word consists of only lowercase and uppercase English letters.
# 
# 
# 
# Follow up: Could you use search pruning to make your solution faster with a
# larger board?
# 
#

# @lc code=start
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        used = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if board[i][j] != word[0]:
                    continue
                if self.dfs(i, j, 0, board, used, word):
                    return True
        return False

    def dfs(self, i, j, k, board, used, word) -> bool:
        m, n = len(board), len(board[0])
        if not self.valid(i, j, m - 1, n - 1):
            return False
        if used[i][j]:
            return False
        else:
            if board[i][j] != word[k]:
                return False
            elif k == len(word) - 1:
                return True
            else:
                used[i][j] = True
                res = self.dfs(i + 1, j, k + 1, board, used, word) or self.dfs(i, j + 1, k + 1, board, used, word) or self.dfs(i - 1, j, k + 1, board, used, word) or self.dfs(i, j - 1, k + 1, board, used, word)
                used[i][j] = False
                return res

    def valid(self, i, j, m, n) -> bool:
        return 0 <= i <= m and 0 <= j <= n


# @lc code=end

