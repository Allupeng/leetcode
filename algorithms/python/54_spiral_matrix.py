#
# @lc app=leetcode id=54 lang=python3
#
# [54] Spiral Matrix
#
# https://leetcode.com/problems/spiral-matrix/description/
#
# algorithms
# Medium (48.28%)
# Likes:    13982
# Dislikes: 1216
# Total Accepted:    1.3M
# Total Submissions: 2.6M
# Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
#
# Given an m x n matrix, return all elements of the matrix in spiral order.
# 
# 
# Example 1:
# 
# 
# Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
# Output: [1,2,3,6,9,8,7,4,5]
# 
# 
# Example 2:
# 
# 
# Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
# Output: [1,2,3,4,8,12,11,10,9,5,6,7]
# 
# 
# 
# Constraints:
# 
# 
# m == matrix.length
# n == matrix[i].length
# 1 <= m, n <= 10
# -100 <= matrix[i][j] <= 100
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m, n = len(matrix), len(matrix[0])
        res = []
        row = col = way = k = 0
        dire = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        left, right, top, bottom = 0, n - 1, 0, m - 1
        for _ in range(m * n):
            res.append(matrix[row][col])
            next_row, next_col = row + dire[way][0], col + dire[way][1]
            if not self.valid(next_row, next_col, left, right, top, bottom):
                if way == 0:
                    top = top + 1
                if way == 1:
                    right = right - 1
                if way == 2:
                    bottom = bottom - 1
                if way == 3:
                    left = left + 1
                way = (way + 1) % 4
            row = row + dire[way][0]
            col = col + dire[way][1]
        return res

    def valid(self, row, col, left, right, top, bottom):
        return top <= row <= bottom and left <= col <= right
        
# @lc code=end

