/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.cn/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (49.31%)
 * Likes:    1394
 * Dislikes: 0
 * Total Accepted:    372.7K
 * Total Submissions: 755.8K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class _0054_SpiralMatrix{
// @lc code=start
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0){
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            //记录的(y,x)的顺序变化
            int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            int way = 0;
            // m * m矩阵
            int m = matrix.length, n = matrix[0].length;
            int x = 0, y = 0; //初始化坐标
            int k = 0;
            int left = 0, right = n - 1;
            int top = 0, bottom = m - 1;
            while(k < m*n){
                // 如果越界，方向进行改变
                if(!avoid(x + pos[way][1], y + pos[way][0], left, right, top, bottom)){
                    // 第top行遍历完毕
                    if(way == 0){
                        top++;
                    }
                    // 第right列遍历完毕
                    if(way == 1){
                        right--;
                    }
                    // 第bottom行遍历完毕
                    if(way == 2){
                        bottom--;
                    }
                    // 第left列遍历完毕
                    if(way == 3){
                        left++;
                    }
                    way = (way + 1) % 4;
                }
                res.add(matrix[y][x]);

                // (x,y)坐标变化
                y += pos[way][0];
                x += pos[way][1];

                k++;
            }
            return res;
        }

    /**
     * 判断坐标(x,y)是否越界
     * @param x x坐标
     * @param y y坐标
     * @param left 左边界
     * @param right 右边界
     * @param top 上边界
     * @param bottom 下边界
     * @return true 未越界 false 越界
     */
        private boolean avoid(int x, int y, int left, int right, int top, int bottom){
            return left <= x && x <= right && top <= y && y <= bottom;
        }

    }
// @lc code=end
    @Test
    public void testSpiralOrder() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSpiralOrderWithEmptyMatrix() {
        Solution solution = new Solution();
        int[][] matrix = {};
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSpiralOrderWithSingleElementMatrix() {
        Solution solution = new Solution();
        int[][] matrix = {{1}};
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSpiralOrderWithOddSizedMatrix() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSpiralOrderWithEvenSizedMatrix() {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(expected, actual);
    }

    @Test
    public void testSpiralOrderWithOneLineSizedMatrix() {
        Solution solution = new Solution();
        int[][] matrix = {{6,9,7}};
        List<Integer> expected = Arrays.asList(6,9,7);
        List<Integer> actual = solution.spiralOrder(matrix);
        assertEquals(expected, actual);
    }

}


