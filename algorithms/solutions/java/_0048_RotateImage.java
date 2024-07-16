/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] Rotate Image
 *
 * https://leetcode.cn/problems/rotate-image/description/
 *
 * algorithms
 * Medium (76.03%)
 * Likes:    1857
 * Dislikes: 0
 * Total Accepted:    570.3K
 * Total Submissions: 750K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * 
 * 
 */

public class _0048_RotateImage {
// @lc code=start
    class Solution {
        public void rotate(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int top = 0, bottom = m - 1;
            while (top < bottom) {
                for(int i = 0; i < n; i++){
                    int t = matrix[top][i];
                    matrix[top][i] = matrix[bottom][i];
                    matrix[bottom][i] = t;
                }
                top++;
                bottom--;
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j <= i; j++){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }
    }
// @lc code=end
}

