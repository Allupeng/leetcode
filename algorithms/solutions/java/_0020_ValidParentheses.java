/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (43.94%)
 * Likes:    4431
 * Dislikes: 0
 * Total Accepted:    1.8M
 * Total Submissions: 4.1M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

import java.util.Stack;

public class _0020_ValidParentheses {
// @lc code=start
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()){
                if (ch == '(' || ch == '{' || ch == '['){
                    stack.push(ch);
                }else{
                    if (stack.isEmpty()){
                        return false;
                    }
                    char open = stack.pop();
                    if (!isValid(open, ch)){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean isValid(char open, char close){
            switch (open){
                case '(':
                    return close == ')';
                case '[':
                    return close == ']';
                case '{':
                    return close == '}';
            }
            return false;
        }
    }
// @lc code=end
}

