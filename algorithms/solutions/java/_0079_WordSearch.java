/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.cn/problems/word-search/description/
 *
 * algorithms
 * Medium (46.89%)
 * Likes:    1806
 * Dislikes: 0
 * Total Accepted:    518.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * 
 * 
 * Follow up: Could you use search pruning to make your solution faster with a
 * larger board?
 * 
 */

public class _0079_WordSearch {
// @lc code=start
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (board[i][j] == word.charAt(0)){
                        boolean found = dfs(board, i, j, 0, word);
                        if (found){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int row, int col, int curIndex, String word){
            if (curIndex == word.length()){
                return true;
            }
            if (!isValid(row, col, board[0].length - 1, board.length - 1) || board[row][col] != word.charAt(curIndex)){
                return false;
            }
            char ch = board[row][col];
            board[row][col] = '/';
            boolean next = dfs(board, row + 1, col, curIndex + 1, word)
                    || dfs(board, row, col + 1, curIndex + 1, word)
                    || dfs(board, row - 1, col, curIndex + 1, word)
                    || dfs(board, row, col - 1, curIndex + 1, word);
            board[row][col] = ch;
            return next;
        }

        private boolean isValid(int row, int col, int right, int bottom){
            return 0 <= row && row <= bottom && 0 <= col && col <= right;
        }
    }
// @lc code=end
}

