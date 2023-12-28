#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#
# https://leetcode.com/problems/n-queens/description/
#
# algorithms
# Hard (67.01%)
# Likes:    11740
# Dislikes: 258
# Total Accepted:    648.3K
# Total Submissions: 967.5K
# Testcase Example:  '4'
#
# The n-queens puzzle is the problem of placing n queens on an n x n chessboard
# such that no two queens attack each other.
# 
# Given an integer n, return all distinct solutions to the n-queens puzzle. You
# may return the answer in any order.
# 
# Each solution contains a distinct board configuration of the n-queens'
# placement, where 'Q' and '.' both indicate a queen and an empty space,
# respectively.
# 
# 
# Example 1:
# 
# 
# Input: n = 4
# Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
# Explanation: There exist two distinct solutions to the 4-queens puzzle as
# shown above
# 
# 
# Example 2:
# 
# 
# Input: n = 1
# Output: [["Q"]]
# 
# 
# 
# Constraints:
# 
# 
# 1 <= n <= 9
# 
# 
#

# @lc code=start
from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [['.' for _ in range(n)] for _ in range(n)]
        self.backtrace(0, board, res)
        return res
    
    def backtrace(self, row: int, board: list, res: list):
        if row == len(board):
            solution = []
            for i in range(len(board)):
                solution.append(''.join(board[i]))
            res.append(solution.copy())
            return
        for col in range(len(board[row])):
            if not self.place(board, row, col):
                continue
            else:
                board[row][col] = 'Q'
                self.backtrace(row + 1, board, res)
                board[row][col] = '.'
        
        # 每次在同一行的不同列进行放置
    
    def place(self, board: list, row, col) -> bool:
        row_len, col_len = len(board), len(board[0])
        if row < 0 or row > row_len or col < 0 or col > col_len:
            return False
        # 同一列不允许有皇后
        for i in range(row):
            if board[i][col] == 'Q':
                return False
        # 同一对角不允许有皇后
        # 左上角
        i, j = row, col
        while i >= 0 and j >= 0:
            if board[i][j] == 'Q':
                return False
            i = i - 1
            j = j - 1
        i, j = row, col
        while i >= 0 and j < col_len:
            if board[i][j] == 'Q':
                return False
            i = i - 1
            j = j + 1
        return True
        
# @lc code=end

