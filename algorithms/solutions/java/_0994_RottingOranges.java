/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.cn/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (51.32%)
 * Likes:    836
 * Dislikes: 0
 * Total Accepted:    163.5K
 * Total Submissions: 318.7K
 * Testcase Example:  '[[2,1,1],[1,1,0],[0,1,1]]'
 *
 * You are given an m x n grid where each cell can have one of three
 * values:
 * 
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * 
 * 
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never
 * rotten, because rotting only happens 4-directionally.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 * 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class _0994_RottingOranges {
// @lc code=start
    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int fresh = 0;
            Queue<int[]> rottenOrangesQueue = new LinkedList<>();
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 1){
                        fresh++;
                    }else if (grid[i][j] == 2){
                        rottenOrangesQueue.offer(new int[]{i, j});
                    }
                }
            }
            if (fresh == 0) return 0;
            int time = 0;
            int[][] pos = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            while (!rottenOrangesQueue.isEmpty() && fresh != 0){
                int size = rottenOrangesQueue.size();
                for (int i = 0; i < size; i++){
                    int[] rottenOrange = rottenOrangesQueue.poll();
                    int y = rottenOrange[0], x = rottenOrange[1];
                    for (int j = 0; j < pos.length; j++){
                        int ny = y + pos[j][0];
                        int nx = x + pos[j][1];
                        if (!isValid(nx, ny, 0, n - 1, 0, m - 1) || grid[ny][nx] != 1){
                            continue;
                        }
                        fresh--;
                        grid[ny][nx] = 2;
                        rottenOrangesQueue.offer(new int[]{ny, nx});
                    }
                }
                time++;
            }
            return fresh == 0 ? time : -1;
        }

        private boolean isValid(int i, int j, int left, int right, int top, int bottom){
            return left <= i && i <= right && top <= j && j <= bottom;
        }
    }
// @lc code=end
}

