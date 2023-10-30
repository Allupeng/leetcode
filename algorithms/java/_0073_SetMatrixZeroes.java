/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (64.26%)
 * Likes:    962
 * Dislikes: 0
 * Total Accepted:    286.4K
 * Total Submissions: 445.6K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */

import org.junit.Test;

public class _0073_SetMatrixZeroes {
// @lc code=start
    class Solution{
        public void setZeroes(int[][] matrix){
            int rows = matrix.length, cols = matrix[0].length;
            boolean firstColumnZero = false, firstRowZero = false;
            for (int i = 0; i < rows; i++){
                if (matrix[i][0] == 0) firstColumnZero = true;
            }
            for (int j = 0; j < cols; j++){
                if (matrix[0][j] == 0) firstRowZero = true;
            }
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    if (matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < rows; i++){
                for (int j = 1; j < cols; j++){
                   if (matrix[i][0] == 0 || matrix[0][j] == 0){
                       matrix[i][j] = 0;
                   }
                }
            }
            if (firstColumnZero){
                for (int i = 0; i < rows; i++){
                    matrix[i][0] = 0;
                }
            }
            if (firstRowZero){
                for (int i = 0; i < cols; i++){
                    matrix[0][i] = 0;
                }
            }
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(matrix);
    }
// @lc code=end

    class SpaceMPlusNSolution {
        public void setZeroes(int[][] matrix){
            // space O(m + n)
            int rows = matrix.length, cols = matrix[0].length;
            // [0, rows - 1]为前 row 行为 0
            // [rows, cols - 1]为前 col 列为 0
            boolean[] mark = new boolean[rows + cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    if (matrix[i][j] == 0){
                        mark[i] = true;
                        mark[j + rows] = true;
                    }
                }
            }
            // 第 i 行置零
            for (int i = 0; i < rows; i++){
                if (mark[i]){
                    for (int j = 0; j < cols; j++){
                        matrix[i][j] = 0;
                    }
                }
            }
            // 第 j 列置零
            for (int j = rows; j < mark.length; j++){
                if (mark[j]){
                    for (int i = 0; i < rows; i++){
                        matrix[i][j - rows] = 0;
                    }
                }
            }
        }
    }

    /**
     * 空间复杂度 O(n²)
     */
    class SpaceN2Solution{
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] mark = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] == 0){
                    inPlaceSpace(mark, i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (mark[i][j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void inPlaceSpace(boolean[][] matrix, int row, int col){
        int rowLen = matrix.length, colLen = matrix[0].length;
        // 同一行
        for (int c = 0; c < colLen; c++){
            matrix[row][c] = true;
        }
        // 同一列
        for (int r = 0; r < rowLen; r++){
            matrix[r][col] = true;
        }
    }
}
}

