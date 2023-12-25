/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.cn/problems/word-search/description/
 *
 * algorithms
 * Medium (46.40%)
 * Likes:    1710
 * Dislikes: 0
 * Total Accepted:    463.9K
 * Total Submissions: 999.7K
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

import org.junit.Assert;
import org.junit.Test;

public class _0079_WordSearch {
// @lc code=start
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    if (board[i][j] != word.charAt(0)){
                        continue;
                    }
                    if(dfs(i, j, 0, board, new boolean[board.length][board[0].length], word)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int k,  char[][] board, boolean[][] used, String word){
            if (!valid(i, j, board.length - 1, board[0].length - 1)){
                return false;
            }
            if (used[i][j]){
                return false;
            }else{
                if (board[i][j] != word.charAt(k)){
                    return false;
                }else if (k == word.length() - 1){
                    return true;
                }
                used[i][j] = true;
                boolean result =  dfs(i + 1, j, k + 1, board, used, word)
                        || dfs(i - 1, j, k + 1, board, used, word)
                        || dfs(i, j + 1, k + 1, board, used, word)
                        || dfs(i, j - 1, k + 1, board, used, word);
                used[i][j] = false;
                return result;
            }
        }

        private boolean valid(int i, int j, int m, int n){
            return 0 <= i && i <= m && 0 <= j && j <= n;
        }

    }
// @lc code=end

    @Test
    public void test(){
        char[][] board  = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCB";
        String word2 = "ABCCEE";
        String word3 = "SEE";
        Solution solution = new Solution();
        Assert.assertFalse(solution.exist(board, word1));
        Assert.assertTrue(solution.exist(board, word2));
        Assert.assertTrue(solution.exist(board, word3));
    }
}

