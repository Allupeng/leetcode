/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (38.28%)
 * Likes:    7179
 * Dislikes: 0
 * Total Accepted:    1.7M
 * Total Submissions: 4.4M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * 
 * 
 */

public class _0005_LongestPalindromicSubstring {
// @lc code=start
    class Solution {
        public String longestPalindrome(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            // dp[i][j] =  (s[i] = s[j]) and dp[i + 1][j - 1]
            // i + 1 -> i, j - 1 -> j
            for (int i = 0; i < s.length(); i++){
                dp[i][i] = true;
            }
            int leftIndex = 0;
            int maxLen = 1;
            for (int i = s.length() - 1; i >= 0; i--){
                for (int j = i + 1; j < s.length(); j++){
                    if (s.charAt(i) == s.charAt(j) && ((i + 1 == j) || dp[i + 1][j - 1])){
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        leftIndex = i;
                    }
                }
            }
            return s.substring(leftIndex, leftIndex + maxLen);
        }
    }
// @lc code=end
}

