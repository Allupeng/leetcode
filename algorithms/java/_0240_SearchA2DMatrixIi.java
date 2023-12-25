/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 *
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (53.15%)
 * Likes:    1372
 * Dislikes: 0
 * Total Accepted:    401.9K
 * Total Submissions: 756.2K
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 5
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
 * target = 20
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -10^9 <= target <= 10^9
 * 
 * 
 */

public class _0240_SearchA2DMatrixIi {
// @lc code=start
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 从右上角出发，像一颗二叉搜索树
            int m = matrix.length, n = matrix[0].length;
            int y = 0, x = n - 1;
            while(valid(y, x, 0, n - 1, 0, m - 1)){
                if(target == matrix[y][x]){
                    return true;
                }else if(target < matrix[y][x]){
                    x--;
                }else{
                    y++;
                }
            }
            return false;
        }

        private boolean valid(int y, int x, int left, int right, int top, int bottom){
            return left <= x && x <= right && top <= y && y <= bottom;
        }
    }
// @lc code=end
}

