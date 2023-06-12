/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 *
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * algorithms
 * Easy (72.37%)
 * Likes:    534
 * Dislikes: 0
 * Total Accepted:    237.5K
 * Total Submissions: 328.1K
 * Testcase Example:  '"abbaca"'
 *
 * You are given a string s consisting of lowercase English letters. A
 * duplicate removal consists of choosing two adjacent and equal letters and
 * removing them.
 * 
 * We repeatedly make duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * can be proven that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent
 * and equal, and this is the only possible move.  The result of this move is
 * that the string is "aaca", of which only "aa" is possible, so the final
 * string is "ca".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "azxxzy"
 * Output: "ay"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 
 * 
 */

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class _1047_RemoveAllAdjacentDuplicatesInString {
// @lc code=start
    class Solution {
        public String removeDuplicates(String s) {
            if (s == null || s.equals("")){
                return "";
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (!stack.isEmpty()){
                    char top = stack.peek();
                    if (top == ch){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }else {
                    stack.push(ch);
                }
            }
            char[] result = new char[stack.size()];
            for (int i = result.length - 1; i >= 0; i--){
                result[i] = stack.pop();
            }
            return new String(result);
        }
    }
// @lc code=end
   @Test
   public void testRemoveDuplicatesWithEmptyString() {
        Solution solution = new Solution();
        String input = "";
        String expectedOutput = "";
        String actualOutput = solution.removeDuplicates(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveDuplicatesWithNoDuplicates() {
        Solution solution = new Solution();
        String input = "abcdefg";
        String expectedOutput = "abcdefg";
        String actualOutput = solution.removeDuplicates(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveDuplicatesWithAdjacentDuplicates() {
        Solution solution = new Solution();
        String input = "abbaca";
        String expectedOutput = "ca";
        String actualOutput = solution.removeDuplicates(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveDuplicatesWithNonAdjacentDuplicates() {
        Solution solution = new Solution();
        String input = "abccba";
        String expectedOutput = "";
        String actualOutput = solution.removeDuplicates(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveDuplicatesWithAllDuplicates() {
        Solution solution = new Solution();
        String input = "aaaaa";
        String expectedOutput = "a";
        String actualOutput = solution.removeDuplicates(input);
        assertEquals(expectedOutput, actualOutput);
    }
}

