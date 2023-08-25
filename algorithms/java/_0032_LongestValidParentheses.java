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
            int maxLength = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch == '('){
                    stack.push(i);
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        stack.push(i);
                    }else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
            return maxLength;
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

