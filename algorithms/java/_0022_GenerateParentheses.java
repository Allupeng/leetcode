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
            backtrack(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private void backtrack(List<String> result, StringBuilder cur, int open, int close, int max){
            if (cur.length() == max * 2){
                result.add(cur.toString());
            }
            if (open < max){
                open = open + 1;
                cur.append("(");
                backtrack(result, cur, open, close, max);
                open = open - 1;
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open){
                close = close + 1;
                cur.append(")");
                backtrack(result, cur, open, close, max);
                close = close - 1;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int n = 3;
        Assert.assertEquals(4, solution.generateParenthesis(n).size());
    }
}

