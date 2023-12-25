/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.cn/problems/n-queens/description/
 *
 * algorithms
 * Hard (74.08%)
 * Likes:    1811
 * Dislikes: 0
 * Total Accepted:    315K
 * Total Submissions: 425.2K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n
 * chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [["Q"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0051_NQueens {
// @lc code=start
    class Solution {
        private final List<List<String>> result = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            if (n == 0){
                return new ArrayList<>();
            }
            char[][] chessboard = new char[n][n];
            for (char[] board : chessboard){
                Arrays.fill(board, '.');
            }
            backtrace(0, n, chessboard);
            return result;
        }

        private void backtrace(int row, int n, char[][] chessboard){
            if (row == n){
                List<String> path = new ArrayList<>();
                for (char[] rows : chessboard){
                    path.add(new String(rows));
                }
                result.add(path);
                return;
            }
            // 保证了同一行只有一个皇后
            for (int col = 0; col < n; col++){
                if (isValidPosition(row, col, chessboard)){
                    chessboard[row][col] = 'Q';
                    backtrace(row + 1, n, chessboard);
                    chessboard[row][col] = '.';
                }
            }
        }

        private boolean isValidPosition(int row, int col, char[][] chessboard){
            // 同一列不能有其他皇后
            for (char[] chars : chessboard) {
                if (chars[col] == 'Q') {
                    return false;
                }
            }
            // 判断左上角没有其他皇后
            int x = col - 1;
            int y = row - 1;
            while (x >= 0 && y >= 0){
                if (chessboard[y][x] == 'Q'){
                    return false;
                }
                x--;
                y--;
            }
            // 判断右上角没有其他皇后
            x = col + 1;
            y = row - 1;
            while (x < chessboard.length && y >= 0){
                if (chessboard[y][x] == 'Q'){
                    return false;
                }
                x++;
                y--;
            }
            return true;
        }
    }
// @lc code=end
}

