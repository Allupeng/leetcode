package hot100;/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (66.39%)
 * Likes:    1047
 * Dislikes: 0
 * Total Accepted:    357.9K
 * Total Submissions: 539.1K
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

public class _0073_SetMatrixZeroes {
// @lc code=start
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean firstRowZero = false;
            boolean firstColZero = false;
            for(int i = 0; i < m; i++){
                if(matrix[i][0] == 0) firstColZero = true;
            }
            for(int i = 0; i < n; i++){
                if(matrix[0][i] == 0) firstRowZero = true;
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
            if(firstColZero){
                for(int i = 0; i < m; i++) matrix[i][0] = 0;
            }
            if(firstRowZero){
                for(int i = 0; i < n; i++) matrix[0][i] = 0;
            }
        }
    }
// @lc code=end
}

