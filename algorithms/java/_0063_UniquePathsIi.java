/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] Unique Paths II
 *
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (41.11%)
 * Likes:    1097
 * Dislikes: 0
 * Total Accepted:    390.3K
 * Total Submissions: 949.3K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * You are given an m x n integer array grid. There is a robot initially
 * located at the top-left corner (i.e., grid[0][0]). The robot tries to move
 * to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only
 * move either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
 * the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to
 * 2 * 10^9.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0063_UniquePathsIi {
// @lc code=start
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rows = obstacleGrid.length;
            int cols = obstacleGrid[0].length;
            int[][] dp = new int[rows][cols];
            for (int i = 0; i < rows && obstacleGrid[i][0] != 1; i++){
                dp[i][0] = 1;
            }
            for (int j = 0; j < cols && obstacleGrid[0][j] != 1; j++){
                dp[0][j] = 1;
            }
            for (int i = 1; i < rows; i++){
                for (int j = 1; j < cols; j++){
                    if (obstacleGrid[i][j] != 1){
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }else {
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]{{0,1},{0,0}};
        Assert.assertEquals(1, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        Assert.assertEquals(2, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]{{1,0}};
        Assert.assertEquals(0, solution.uniquePathsWithObstacles(obstacleGrid));
    }
}

