/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] Distinct Subsequences
 *
 * https://leetcode.cn/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (52.19%)
 * Likes:    1093
 * Dislikes: 0
 * Total Accepted:    145.9K
 * Total Submissions: 279.5K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 * rabbbit
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from s.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 * 
 * 
 */

public class _0115_DistinctSubsequences {
// @lc code=start
    class Solution {
        public int numDistinct(String s, String t) {
            //dp[i][j] 定义为 [0... i - 1]的字符串 和 [0 ... j - 1]的字符串最多不同子序列
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            dp[0][0] = 1;
            for (int i = 1; i < s.length() + 1; i++){
                dp[i][0] = 1;
            }
            for (int j = 1; j < t.length() + 1; j++){
                dp[0][j] = 0;
            }

            for (int i = 1; i < s.length() + 1; i++){
                for (int j = 1; j < t.length() + 1; j++){
                    if (s.charAt(i - 1) == t.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][t.length()];
        }
    }
// @lc code=end
}

