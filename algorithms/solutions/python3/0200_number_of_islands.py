#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] Number of Islands
#
# https://leetcode.cn/problems/number-of-islands/description/
#

# @lc code=start
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        islands = 0
        m, n = len(grid), len(grid[0])
        
        def dfs(row: int, col: int):
            if not (0 <= row <= m - 1 and 0 <= col <= n - 1) or grid[row][col] == '0':
                return
            grid[row][col] = '0'
            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    islands = islands + 1
                    dfs(i, j)
        
        
        return islands
        
        
# @lc code=end

