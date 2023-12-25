/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (72.96%)
 * Likes:    1064
 * Dislikes: 0
 * Total Accepted:    321.3K
 * Total Submissions: 440.3K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 
 * 
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class _0059_SpiralMatrixIi{
// @lc code=start
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int rowStart = 0, rowEnd = n - 1;
            int colStart = 0, colEnd = n - 1;
            int value = 1;
            while(rowStart <= rowEnd && colStart <= colEnd){
                // first row from left to right
                for(int i = colStart; i < colEnd; i++){
                    res[rowStart][i] = value++;
                }
                // last column from top to down
                for(int i = rowStart; i < rowEnd; i++){
                    res[i][colEnd] = value++;
                }
                // last row from right to left
                for(int i = colEnd; i > colStart; i--){
                    res[rowEnd][i] = value++;
                }
                // first column from down to top
                for(int i = rowEnd; i > rowStart; i--){
                    res[i][colStart] = value++;
                }
                rowStart++;
                colStart++;
                rowEnd--;
                colEnd--;
            }
            if(n % 2 == 1){
                res[n / 2][n / 2] = value;
            }
            return res;
        }
    }
// @lc code=end
    
    @Test
    public void testGenerateMatrixWithSizeOne() {
        int n = 1;
        Solution solution = new Solution();
        int[][] expected = {{1}};
        int[][] actual = solution.generateMatrix(n);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testGenerateMatrixWithSizeTwo() {
        int n = 2;
        Solution solution = new Solution();
        int[][] expected = {{1, 2}, {4, 3}};
        int[][] actual = solution.generateMatrix(n);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testGenerateMatrixWithSizeThree() {
        int n = 3;
        Solution solution = new Solution();
        int[][] expected = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] actual = solution.generateMatrix(n);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testGenerateMatrixWithSizeFour() {
        int n = 4;
        Solution solution = new Solution();
        int[][] expected = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] actual = solution.generateMatrix(n);
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testGenerateMatrixWithSizeFive() {
        int n = 5;
        Solution solution = new Solution();
        int[][] expected = {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};
        int[][] actual = solution.generateMatrix(n);
        assertArrayEquals(expected, actual);
    }
}

