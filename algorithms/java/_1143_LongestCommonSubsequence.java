/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 *
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (64.87%)
 * Likes:    1372
 * Dislikes: 0
 * Total Accepted:    353.7K
 * Total Submissions: 545.1K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * 
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _1143_LongestCommonSubsequence {
// @lc code=start
    class Solution {
        private int[][] dp;
        public int longestCommonSubsequence(String text1, String text2) {
            // using Top-Down Memorization
            int m = text1.length();
            int n = text2.length();
            dp = new int[m + 1][n + 1];
            for (int[] ints : dp){
                Arrays.fill(ints, -1);
            }
            lcs(text1, text2, m, n);
            return dp[m][n];
        }

        private int lcs(String text1, String text2, int m, int n){
            if (m == 0 || n == 0){
                return 0;
            }
            if (dp[m][n] != -1){
                return dp[m][n];
            }
            if (text1.charAt(m - 1) == text2.charAt(n - 1)){
                dp[m][n] = 1 + lcs(text1, text2, m - 1, n - 1);
            }else{
                dp[m][n] = Math.max(lcs(text1, text2, m, n - 1), lcs(text1, text2, m - 1, n));
            }
            return dp[m][n];
        }

    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        String text1 = "abcde", text2 = "ace";
        Assert.assertEquals( 3, solution.longestCommonSubsequence(text1, text2));
    }

}
