/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (37.69%)
 * Likes:    6728
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 4M
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

import org.junit.Assert;
import org.junit.Test;

public class _0005_LongestPalindromicSubstring {
// @lc code=start
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int maxLen = 1;
            int left = 0;
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++){
                dp[i][i] = true;
            }
            for (int i = n - 1; i >= 0; i--){
                for (int j = i + 1; j < n; j++){
                    System.out.printf("当前计算的为dp[%s][%s]%n", i, j);
                    if ( s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1])){
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen){
                            maxLen = j - i + 1;
                            left = i;
                        }
                    }
                }
            }
            return s.substring(left, left + maxLen);
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        String s = "abcba";
        Assert.assertEquals("abcba", solution.longestPalindrome(s));
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String s = "cbbd";
        Assert.assertEquals("bb", solution.longestPalindrome(s));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String s = "bb";
        Assert.assertEquals("bb", solution.longestPalindrome(s));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String s = "a";
        Assert.assertEquals("a", solution.longestPalindrome(s));
    }
}

