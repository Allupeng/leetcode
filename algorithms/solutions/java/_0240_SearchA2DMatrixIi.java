 /*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 *
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (53.71%)
 * Likes:    1462
 * Dislikes: 0
 * Total Accepted:    456.7K
 * Total Submissions: 850.3K
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
            int m = matrix.length, n = matrix[0].length;
            int top = 0, right = n - 1;
            while (top < m && right >= 0) {
                int cur = matrix[top][right];
                if (target == cur) {
                    return true;
                }else if(target < cur){
                    right--;
                }else{
                    top++;
                }
            }
            return false;
        }
    }
// @lc code=end
}

