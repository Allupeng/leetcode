 /*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.cn/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (50.73%)
 * Likes:    1664
 * Dislikes: 0
 * Total Accepted:    511.1K
 * Total Submissions: 1M
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
import java.util.List;

public class _0054_SpiralMatrix {
// @lc code=start
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            int way = 0;
            int k = 0;
            int y = 0, x = 0;
            int[][] pos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            List<Integer> result = new ArrayList<>();
            while(k < matrix.length * matrix[0].length){
                int nextY = y + pos[way][0];
                int nextX = x + pos[way][1];
                if (!valid(nextX, nextY, left, right, top, bottom)) {
                    if (way == 0) {
                        top++;
                    }
                    if (way == 1){
                        right--;
                    }
                    if (way == 2) {
                        bottom--;
                    }
                    if (way == 3) {
                        left++;
                    }
                    way = (way + 1) % 4;
                }
                result.add(matrix[y][x]);
                y = y + pos[way][0];
                x = x + pos[way][1];
                k++;
            }
            return result;
        }

        private boolean valid(int x, int y, int left, int right, int top, int bottom){
            return left <= x && x <= right && top <= y && y <= bottom;
        }
    }
// @lc code=end
}

