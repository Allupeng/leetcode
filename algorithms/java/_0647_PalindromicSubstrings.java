/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.cn/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (66.89%)
 * Likes:    1214
 * Dislikes: 0
 * Total Accepted:    290.1K
 * Total Submissions: 433.7K
 * Testcase Example:  '"abc"'
 *
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * 
 * 
 */

public class _0647_PalindromicSubstrings {
// @lc code=start
    class Solution {
        public int countSubstrings(String s) {
            // dp[i][j] 代表 s[i,j]是否为回文串
            boolean[][] dp = new boolean[s.length()][s.length()];
            int result = 0;
            // 遍历顺序很重要
            for (int i = s.length() - 1; i >= 0; i--){
                for (int j = i; j < s.length(); j++){
                    if (s.charAt(i) == s.charAt(j)){
                        //1. 长度为1
                        if (j - i <= 1){
                            result++;
                            dp[i][j] = true;
                        }else if (dp[i + 1][j - 1]){
                            result++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return result;
        }
    }
// @lc code=end
}

