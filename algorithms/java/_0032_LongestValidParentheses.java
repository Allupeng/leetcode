/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (37.32%)
 * Likes:    2342
 * Dislikes: 0
 * Total Accepted:    391K
 * Total Submissions: 1M
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

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class _0032_LongestValidParentheses {
// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.equals("")) return 0;
        int n = s.length();
        if(n == 1) return 0;
        if(n == 2){
            return s.charAt(0) == '(' && s.charAt(1) == ')' ? 2 : 0;
        }
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') dp[i] = 0;
        }
        char[] chars = s.toCharArray();
        for(int i = 1; i < n; i++){
            if(chars[i] == ')'){
                if(chars[i - 1] == '('){
                    if(i - 1 <= 0){
                        dp[i] = 2;
                    }else{
                        dp[i] = dp[i - 2] + 2;
                    }
                    //前一个为右括号
                }else{
                    if(dp[i - 1] > 0){
                        int preLeftIndex = i - 1 - dp[i - 1];
                        if(preLeftIndex >= 0 && chars[preLeftIndex] == '('){
                            // 如果前一部分存在
                            if(preLeftIndex - 1 > 0){
                                dp[i] = dp[preLeftIndex - 1] + dp[i - 1] + 2;
                            }else{
                                dp[i] = dp[i - 1] + 2;
                            }
                        }
                    }
                }
            }
        }
        int ans = dp[0];
        for(int i = 0; i < dp.length; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        String s = ")()())";
        Assert.assertEquals(4, solution.longestValidParentheses(s));
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        String s = "";
        Assert.assertEquals(0, solution.longestValidParentheses(s));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        String s = ")()((())";
        Assert.assertEquals(4, solution.longestValidParentheses(s));
    }

}

