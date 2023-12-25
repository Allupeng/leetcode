/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.47%)
 * Likes:    3354
 * Dislikes: 0
 * Total Accepted:    732.4K
 * Total Submissions: 945.4K
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

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses {
// @lc code=start
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrace(n, 0, 0, new StringBuilder(), result);
            return result;
        }

        private void backtrace(int n, int open, int close, StringBuilder cur, List<String> result){
            if (open == n && close == n){
                result.add(cur.toString());
                return;
            }
            if (open < n){
                backtrace(n, open + 1, close, cur.append('('), result);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (open > close){
                backtrace(n, open, close + 1, cur.append(')'), result);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int n = 3;
        Assert.assertEquals(5, solution.generateParenthesis(n).size());
    }
}

