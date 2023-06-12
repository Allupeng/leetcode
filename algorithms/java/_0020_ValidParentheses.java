/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (44.06%)
 * Likes:    3969
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 3.4M
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

import org.junit.Test;

import java.util.Stack;

public class _0020_ValidParentheses {
// @lc code=start
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch == '[' || ch == '{' || ch == '('){
                    stack.push(ch);
                }
                if (ch == ']' || ch == '}' || ch == ')'){
                    // pop and match if matched
                    if (stack.isEmpty()){
                        return false;
                    }
                    char left = stack.pop();
                    if (!match(left, ch)){
                        return false;
                    }
                }
            }
            return stack.size() == 0;
        }

    private boolean match(char left, char right) {
        switch (left) {
            case '[':
                return right == ']';
            case '(':
                return right == ')';
            case '{':
                return right == '}';
            default:
                return false;
        }
    }
    }
// @lc code=end
    @Test
    public void test01(){
        String s1 = "[";
        Solution solution = new Solution();
        boolean result = solution.isValid(s1);
        assert !result;
    }
}

