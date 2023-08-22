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
            //dp[i][j]代表 s[i,j]的最长回文子串长度
            // dp[i][j] = dp[i + 1][j - 1] && s[i][j]
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++){
                dp[i][i] = true;
                left = i;
            }

            for (int i = s.length() - 1; i >= 0; i --){
                for (int j = i + 1; j < s.length(); j++){
                    if (s.charAt(i) == s.charAt(j) && ((i + 1 == j) || dp[i + 1][j - 1])){
                        dp[i][j] = true;
                        if (maxLen < j - i + 1){
                            left = i;
                            maxLen = j - i + 1;
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
        String s = "babad";
        Assert.assertEquals("aba", solution.longestPalindrome(s));
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
}

