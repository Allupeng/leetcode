/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.cn/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (30.71%)
 * Likes:    3694
 * Dislikes: 0
 * Total Accepted:    382.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string s and a pattern p, implement regular expression
 * matching with support for '.' and '*' where:
 * 
 * 
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0010_RegularExpressionMatching {
// @lc code=start
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            //dp[i][j]代表以s前i个字符是否能够被p的前j个字符所匹配上
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            // j from 1 to n是和dp定义有关
            for (int j = 1; j <= n; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= m; i++){
                for (int j = 1; j <= n; j++){
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else if (p.charAt(j - 1) == '*'){
                        /*
                          1.可以是0个 x* 所以dp[i][j] = dp[i][j - 2]
                          2.可以是匹配一个 x，然后考虑是否继续匹配 dp[i][j]取决于dp[i - 1][j]有两种情况
                            2.1 j - 2的字符为.
                            2.2 j - 2的字符和i - 1的字符相等
                         */
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) ;
                    }
                }
            }

            return dp[m][n];
        }
    }
// @lc code=end

    @Test
    public void testIsMatch() {
        // Test case 1: Valid input
        String s1 = "aa";
        String p1 = "a";
        boolean expected1 = false;
        boolean result1 = new Solution().isMatch(s1, p1);
        assertEquals(expected1, result1);

        // Test case 2: Valid input
        String s2 = "aa";
        String p2 = "a*";
        boolean expected2 = true;
        boolean result2 = new Solution().isMatch(s2, p2);
        assertEquals(expected2, result2);

        // Test case 3: Valid input
        String s3 = "ab";
        String p3 = ".*";
        boolean expected3 = true;
        boolean result3 = new Solution().isMatch(s3, p3);
        assertEquals(expected3, result3);

        // Test case 3: Valid input
        String s4 = "aab";
        String p4 = "b.*";
        boolean expected4 = false;
        boolean result4 = new Solution().isMatch(s4, p4);
        assertEquals(expected4, result4);
    }
}

