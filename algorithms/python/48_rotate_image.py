#
# @lc app=leetcode id=48 lang=python3
#
# [48] Rotate Image
#
# https://leetcode.com/problems/rotate-image/description/
#
# algorithms
# Medium (73.24%)
# Likes:    16754
# Dislikes: 746
# Total Accepted:    1.5M
# Total Submissions: 2.1M
# Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
#
# You are given an n x n 2D matrix representing an image, rotate the image by
# 90 degrees (clockwise).
# 
# You have to rotate the image in-place, which means you have to modify the
# input 2D matrix directly. DO NOT allocate another 2D matrix and do the
# rotation.
# 
# 
# Example 1:
# 
# 
# Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
# Output: [[7,4,1],[8,5,2],[9,6,3]]
# 
# 
# Example 2:
# 
# 
# Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
# Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
# 
# 
# 
# Constraints:
# 
# 
# n == matrix.length == matrix[i].length
# 1 <= n <= 20
# -1000 <= matrix[i][j] <= 1000
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rows, cols = len(matrix), len(matrix[0])
        top, bottom = 0, rows - 1
        while top < bottom:
            self.swap(matrix, top, bottom)
            top += 1
            bottom -= 1
        # 沿对角线进行交换
        for i in range(rows):
            for j in range(cols):
                if i >= j:
                    continue
                t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
    
    def swap(self, matrix, left, right):
        t = matrix[left]
        matrix[left] = matrix[right]
        matrix[right] = t

        
        
# @lc code=end

