/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (49.58%)
 * Likes:    921
 * Dislikes: 0
 * Total Accepted:    398.4K
 * Total Submissions: 803.6K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * You are given an m x n integer matrix matrix with the following two
 * properties:
 * 
 * 
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Given an integer target, return true if target is in matrix or false
 * otherwise.
 * 
 * You must write a solution in O(log(m * n)) time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * 
 * 
 */

public class _0074_SearchA2DMatrix {
// @lc code=start
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int top = 0, right = matrix[0].length - 1;
            while (top < matrix.length && right >= 0){
                int cur = matrix[top][right];
                if (target == cur){
                    return true;
                }else if (target < cur){
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

