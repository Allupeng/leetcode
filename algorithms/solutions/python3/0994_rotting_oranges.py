#
# @lc app=leetcode.cn id=994 lang=python3
#
# [994] Rotting Oranges
#
# https://leetcode.cn/problems/rotting-oranges/description/
#
# algorithms
# Medium (52.91%)
# Likes:    933
# Dislikes: 0
# Total Accepted:    227.1K
# Total Submissions: 429.3K
# Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
#
# You are given an m x n grid where each cell can have one of three
# values:
# 
# 
# 0 representing an empty cell,
# 1 representing a fresh orange, or
# 2 representing a rotten orange.
# 
# 
# Every minute, any fresh orange that is 4-directionally adjacent to a rotten
# orange becomes rotten.
# 
# Return the minimum number of minutes that must elapse until no cell has a
# fresh orange. If this is impossible, return -1.
# 
# 
# Example 1:
# 
# 
# Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
# Output: 4
# 
# 
# Example 2:
# 
# 
# Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
# Output: -1
# Explanation: The orange in the bottom left corner (row 2, column 0) is never
# rotten, because rotting only happens 4-directionally.
# 
# 
# Example 3:
# 
# 
# Input: grid = [[0,2]]
# Output: 0
# Explanation: Since there are already no fresh oranges at minute 0, the answer
# is just 0.
# 
# 
# 
# Constraints:
# 
# 
# m == grid.length
# n == grid[i].length
# 1 <= m, n <= 10
# grid[i][j] is 0, 1, or 2.
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        freshCount = 0
        rottenOranges = []
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    freshCount += 1
                if grid[i][j] == 2:
                    rottenOranges.append([i, j])
        
        minutes = 0
        if freshCount == 0:
            return 0
        
        while rottenOranges:
            size = len(rottenOranges)
            rotten = False
            for i in range(size):
                (y, x) = rottenOranges.pop(0)
                pos = [[-1, 0], [1, 0], [0, -1], [0, 1]]
                for j in range(4):
                    nextY = y + pos[j][0]
                    nextX = x + pos[j][1]
                    if (0 <= nextY <= m - 1 and 0 <= nextX <= n - 1) and grid[nextY][nextX] == 1:
                        grid[nextY][nextX] = 2
                        rottenOranges.append([nextY, nextX])
                        freshCount -= 1
                        rotten = True
            if rotten:
                minutes += 1
                        
            
        return -1 if freshCount > 0 else minutes
        
# @lc code=end

