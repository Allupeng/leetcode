/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.cn/problems/n-queens/description/
 *
 * algorithms
 * Hard (73.93%)
 * Likes:    2069
 * Dislikes: 0
 * Total Accepted:    394.1K
 * Total Submissions: 533K
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
        public List<List<String>> solveNQueens(int n) {
            if (n == 0) return new ArrayList<>();
            List<List<String>> result = new ArrayList<>();
            backtrace(0, new int[n], result);
            return result;
        }

        private void backtrace(int row, int[] board, List<List<String>> result){
            if (row == board.length){
                result.add(generateBoards(board));
                return;
            }
            for (int col = 0; col < board.length; col++){
                // 天然不同一行
                if (isValid(row, col, board)){
                    board[row] = col;
                    backtrace(row + 1, board, result);
                    board[row] = 0;
                }
            }
        }

        private boolean isValid(int curRow, int curCol, int[] board){
            // 不同一列 & 不同对角线
            for (int row = 0; row < curRow; row++){
                if (board[row] == curCol) return false;
                if (Math.abs(board[row] - curCol) == Math.abs(row - curRow)) return false;
            }
            return true;
        }

        private List<String> generateBoards(int[] board){
            List<String> result = new ArrayList<>();
            for (int j : board) {
                char[] chars = new char[board.length];
                Arrays.fill(chars, '.');
                chars[j] = 'Q';
                result.add(new String(chars));
            }
            return result;
        }
    }
// @lc code=end
}

