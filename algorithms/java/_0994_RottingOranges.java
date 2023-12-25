/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] Rotting Oranges
 *
 * https://leetcode.cn/problems/rotting-oranges/description/
 *
 * algorithms
 * Medium (51.12%)
 * Likes:    776
 * Dislikes: 0
 * Total Accepted:    132.4K
 * Total Submissions: 258.8K
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
            Queue<int[]> queue = new LinkedList<>();
            int fresh = 0;
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 1){
                        fresh++;
                    }else if (grid[i][j] == 2){
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            if (fresh == 0) return 0;
            int[] x = new int[]{-1,0,1,0}, y = new int[]{0,1,0,-1};
            int time = 0;
            while (!queue.isEmpty() && fresh > 0){
                time++;
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    int[] cur = queue.poll();
                    for (int j = 0; j < 4; j++){
                        int ny = cur[0] + y[j], nx = cur[1] + x[j];
                        if (!(0 <= ny && ny <= m - 1 && 0 <= nx && nx <= n - 1 && grid[ny][nx] == 1)){
                            continue;
                        }
                        fresh--;
                        grid[ny][nx] = 2;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
            return fresh > 0 ? -1 : time;
        }
    }
// @lc code=end
}
