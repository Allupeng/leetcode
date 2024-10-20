#
# @lc app=leetcode.cn id=48 lang=python3
#
# [48] Rotate Image
#
# https://leetcode.cn/problems/rotate-image/description/
#

# @lc code=start
from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        top, bottom = 0, len(matrix[0]) - 1
        while top < bottom:
            for i in range(len(matrix)):
                matrix[top][i], matrix[bottom][i] = matrix[bottom][i], matrix[top][i]
            top += 1
            bottom -= 1
        for i in range(len(matrix)):
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
            
        
# @lc code=end

