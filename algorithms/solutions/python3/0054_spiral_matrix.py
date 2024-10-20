#
# @lc app=leetcode.cn id=54 lang=python3
#
# [54] Spiral Matrix
#
# https://leetcode.cn/problems/spiral-matrix/description/
#

# @lc code=start
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        def isValid(y, x, left, right, top, down):
            return left <= x <= right and top <= y <= down
        m = len(matrix)
        n = len(matrix[0])
        way = 0
        k = y = x = 0
        left, right, top, down = 0, n - 1, 0, m - 1
        des = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        res = []
        while k < m * n:
            nextY = y + des[way][0]
            nextX = x + des[way][1]
            if not isValid(nextY, nextX, left, right, top, down):
                if way == 0:
                    top += 1
                if way == 1:
                    right -= 1
                if way == 2:
                    down -= 1
                if way == 3:
                    left += 1
                way = (way + 1) % 4
            res.append(matrix[y][x])
            y = y + des[way][0]
            x = x + des[way][1]
            k = k + 1
        return res
                    
            
        
# @lc code=end

