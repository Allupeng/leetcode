#
# @lc app=leetcode.cn id=240 lang=python3
#
# [240] Search a 2D Matrix II
#
# https://leetcode.cn/problems/search-a-2d-matrix-ii/description/
#

# @lc code=start
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
      top, right = 0, len(matrix[0]) - 1
      while top < len(matrix) and right >= 0:
        cur = matrix[top][right]
        if cur == target:
          return True
        elif target < cur:
          right -= 1
        else:
          top += 1
      return False
        
# @lc code=end

