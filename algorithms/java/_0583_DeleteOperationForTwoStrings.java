/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (66.70%)
 * Likes:    607
 * Dislikes: 0
 * Total Accepted:    130.9K
 * Total Submissions: 196.2K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 * 
 * 
 */

public class _0583_DeleteOperationForTwoStrings {
// @lc code=start
    class Solution {
        public int minDistance(String word1, String word2) {
            // dp[i][j] 代表[0...i - 1] [0 ... j - 1]的最小删除步数
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
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 2);
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
// @lc code=end
}
