/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] Rotate Image
 *
 * https://leetcode.cn/problems/rotate-image/description/
 *
 * algorithms
 * Medium (74.93%)
 * Likes:    1718
 * Dislikes: 0
 * Total Accepted:    481.1K
 * Total Submissions: 642.1K
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

import org.junit.Test;

public class _0048_RotateImage {
// @lc code=start
    class Solution {
        public void rotate(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int top = 0, bottom = m - 1;
            while (top < bottom){
                for (int j = 0; j < n; j++){
                    int t = matrix[top][j];
                    matrix[top][j] = matrix[bottom][j];
                    matrix[bottom][j] = t;
                }
                top++;
                bottom--;
            }
            //沿着对角线进行交换
            for (int i = 0; i < n; i++){
                for (int j = 0; j < i; j++){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
    }
}

