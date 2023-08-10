/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.cn/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (67.16%)
 * Likes:    1083
 * Dislikes: 0
 * Total Accepted:    191.9K
 * Total Submissions: 285.7K
 * Testcase Example:  '"bbbab"'
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 * 
 * 
 */

public class _0516_LongestPalindromicSubsequence {
// @lc code=start
    class Solution {
        public int longestPalindromeSubseq(String s) {
            //dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++)
                dp[i][i] = 1;
            for (int i = s.length() - 1; i >= 0; i--){
                for (int j = i + 1; j < s.length(); j++){
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }
// @lc code=end
}

