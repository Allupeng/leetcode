/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.66%)
 * Likes:    3564
 * Dislikes: 0
 * Total Accepted:    833.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses {
// @lc code=start
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 0) return new ArrayList<>();
            List<String> result = new ArrayList<>();
            backtrace(0, 0, n, new StringBuilder(), result);
            return result;
        }

        private void backtrace(int open, int close, int n, StringBuilder str, List<String> result){
            if (str.length() == 2 * n){
                result.add(str.toString());
                return;
            }
            if (open < n){
                str.append('(');
                backtrace(open + 1, close, n, str, result);
                str.deleteCharAt(str.length() - 1);
            }
            if (open > close){
                str.append(')');
                backtrace(open, close + 1, n, str, result);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
// @lc code=end
}

