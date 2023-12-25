/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.cn/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (67.54%)
 * Likes:    1670
 * Dislikes: 0
 * Total Accepted:    210.8K
 * Total Submissions: 312.2K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * The '.' character indicates empty cells.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output:
 * [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is
 * shown below:
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * 
 * 
 */


public class _0037_SudokuSolver {
    // @lc code=start
    class Solution {

        public void solveSudoku(char[][] board) {
            backtrace(board);
        }

        private boolean backtrace(char[][] board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] != '.') continue;
                    for (char character = '1'; character <= '9'; character++) {
                        if (isValid(board, row, col, character)) {
                            board[row][col] = character;
                            if (backtrace(board)) {
                                return true;
                            }
                            board[row][col] = '.';

                        }
                    }
                    return false;
                }
            }
            return true;
        }

        /**
         * rule :
         * * Each of the digits 1-9 must occur exactly once in each row.
         * * Each of the digits 1-9 must occur exactly once in each column.
         * * Each of the digits 1-9 must occur exactly once in each of the 9 3x3
         * * sub-boxes of the grid.
         */
        private boolean isValid(char[][] board, int row, int col, char character) {
            for (int i = 0; i < 9; i++) {
                // Each of the digits 1-9 must occur exactly once in each row.
                if (board[i][col] == character) {
                    return false;
                }
                // Each of the digits 1-9 must occur exactly once in each column.
                if (board[row][i] == character) {
                    return false;
                }
            }
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int r = startRow; r < startRow + 3; r++){
                for (int c = startCol; c < startCol + 3; c++){
                    if (board[r][c] == character){
                        return false;
                    }
                }
            }

            return true;
        }
    }
// @lc code=end
}

