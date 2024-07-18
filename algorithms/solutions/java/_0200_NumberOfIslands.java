/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.cn/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (60.45%)
 * Likes:    2476
 * Dislikes: 0
 * Total Accepted:    824.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * 
 * 
 */

public class _0200_NumberOfIslands {
// @lc code=start
    class Solution {
        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int islands = 0;
            for(int row = 0; row < m; row++){
                for (int col = 0; col < n; col++){
                    if (grid[row][col] == '1'){
                        dfs(grid, row, col);
                        islands++;
                    }
                }
            }
            return islands;
        }

        // change the grid[i][j] from '1' to '0'
        private void dfs(char[][] grid, int row, int col){
            if (!valid(row, col, 0, grid[0].length - 1, 0, grid.length - 1) || grid[row][col] == '0'){
                return;
            }
            grid[row][col] = '0';
            dfs(grid, row + 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row - 1, col);
            dfs(grid, row, col - 1);
        }

        private boolean valid(int row, int col, int left, int right, int top, int bottom){
            return left <= col && col <= right && top <= row && row <= bottom;
        }
    }
// @lc code=end
}

