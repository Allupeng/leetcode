/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] Is Subsequence
 *
 * https://leetcode.cn/problems/is-subsequence/description/
 *
 * algorithms
 * Easy (52.42%)
 * Likes:    912
 * Dislikes: 0
 * Total Accepted:    320.4K
 * Total Submissions: 611.2K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * s and t consist only of lowercase English letters.
 * 
 * 
 * 
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k
 * >= 10^9, and you want to check one by one to see if t has its subsequence.
 * In this scenario, how would you change your code?
 */

import org.junit.Assert;
import org.junit.Test;

public class _0392_IsSubsequence {
// @lc code=start
    class Solution {
        public boolean isSubsequence(String s, String t) {
            // dp[i][j] 代表以 i - 1 的字符串s1 和以j-1为结尾的字符串t1的子序列最长长度
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= s.length(); i++){
                for (int j = 1; j <= t.length(); j++){
                    if (s.charAt(i - 1) == t.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
                        // 相当于j删除一个元素,比较i-1 和j-2的结果
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[s.length()][t.length()] >= s.length();
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();

        Assert.assertTrue(solution.isSubsequence("abc", "abec"));
    }
}

