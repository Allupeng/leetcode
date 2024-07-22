/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (37.89%)
 * Likes:    2492
 * Dislikes: 0
 * Total Accepted:    444K
 * Total Submissions: 1.2M
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', return the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = ""
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 3 * 10^4
 * s[i] is '(', or ')'.
 * 
 * 
 */

public class _0032_LongestValidParentheses {
// @lc code=start
    class Solution {
        public int longestValidParentheses(String s) {
            if (s.isEmpty()) return 0;
            // dp[i] 代表s[0..i-1]的最长有效括号长度
            int result = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++){
                if (s.charAt(i) == ')'){
                    if (s.charAt(i - 1) == '('){
                        dp[i] = 2;
                        if (i - 2 >= 0){
                            dp[i] += dp[i - 2];
                        }
                    }else{
                        // ...((...))
                        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                            dp[i] = 2 + dp[i - 1];
                            if (i - dp[i - 1] - 2 >= 0){
                                dp[i] += dp[i - dp[i - 1] - 2];
                            }
                        }
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
// @lc code=end
}

