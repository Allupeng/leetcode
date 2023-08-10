/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.cn/problems/edit-distance/description/
 *
 * algorithms
 * Hard (62.79%)
 * Likes:    3066
 * Dislikes: 0
 * Total Accepted:    387K
 * Total Submissions: 616.4K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * 
 * 
 */

public class _0072_EditDistance {
// @lc code=start
    class Solution {
        public int minDistance(String word1, String word2) {
            // dp[i][j] 代表[0... i - 1] [0 ... j - 1]的最小编辑距离
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= word1.length(); i++){
                dp[i][0] = i;
            }
            for (int j = 1; j <= word2.length(); j++){
                dp[0][j] = j;
            }
            for (int i = 1; i <= word1.length(); i++){
                for (int j = 1; j <= word2.length(); j++){
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        int insert = dp[i][j - 1] + 1;
                        int delete = dp[i - 1][j] + 1;
                        int update = dp[i - 1][j - 1] + 1;
                        dp[i][j] = Math.min(insert, Math.min(delete, update));
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
// @lc code=end
}

