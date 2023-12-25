/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (48.99%)
 * Likes:    858
 * Dislikes: 0
 * Total Accepted:    340.9K
 * Total Submissions: 695.9K
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

import org.junit.Test;

public class _0074_SearchA2DMatrix {
// @lc code=start
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix.length == 0 || matrix[0].length == 0) return false;
            // 先从第一列开始搜索,列的策略是找最后一个小于等于 target 的数
            int lo = 0, hi = matrix.length - 1;
            int row;
            while(lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                if(matrix[mid][0] <= target){
                    lo = mid + 1;
                }else if(target < matrix[mid][0]){
                    hi = mid - 1;
                }
            }
            if(hi - 1 < 0 || hi - 1 >= matrix.length) return false;
            row = hi - 1;
            return binarySearch(matrix[row], target);
        }

        private boolean binarySearch(int[] nums, int target){
            int lo = 0, hi = nums.length - 1;
            while(lo <= hi){
                int mid = lo + ((hi - lo) >> 1);
                if(target < nums[mid]){
                    hi = mid - 1;
                }else if(nums[mid] < target){
                    lo = mid + 1;
                }else{
                    return true;
                }
            }
            return false;
        }
    }
// @lc code=end
    @Test
    public void test(){
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        solution.searchMatrix(matrix, 3);
    }
}
