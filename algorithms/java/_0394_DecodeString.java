/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.cn/problems/decode-string/description/
 *
 * algorithms
 * Medium (56.95%)
 * Likes:    1630
 * Dislikes: 0
 * Total Accepted:    272.1K
 * Total Submissions: 477.5K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; there are no extra
 * white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits
 * are only for those repeat numbers, k. For example, there will not be input
 * like 3a or 2[4].
 * 
 * The test cases are generated so that the length of the output will never
 * exceed 10^5.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets
 * '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * 
 * 
 */

import java.util.Stack;

public class _0394_DecodeString {
// @lc code=start
    class Solution {
        public String decodeString(String s) {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()){
                if (ch != ']'){
                    stack.push(ch);
                }else {
                    // 取出[]中的字符
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty() && Character.isLetter(stack.peek())){
                        sb.insert(0, stack.pop());
                    }
                    // 保存字符
                    String str = sb.toString();
                    stack.pop();
                    sb = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                        sb.insert(0, stack.pop());
                    }
                    int count = Integer.parseInt(sb.toString());
                    while (count > 0){
                        for (Character character : str.toCharArray()){
                            stack.push(character);
                        }
                        count--;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()){
                result.insert(0, stack.pop());
            }
            return result.toString();
        }
    }
// @lc code=end
}

