/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.cn/problems/edit-distance/description/
 *
 * algorithms
 * Medium (62.83%)
 * Likes:    3373
 * Dislikes: 0
 * Total Accepted:    476.5K
 * Total Submissions: 758.4K
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
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= m; i++){
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++){
                dp[0][j] = j;
            }
            // dp[i][j] = dp[i - 1][j] dp
            for (int i = 1; i <= m; i++){
                for (int j = 1; j <= n; j++){
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
// @lc code=end
}

