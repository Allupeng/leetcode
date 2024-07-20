/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.cn/problems/decode-string/description/
 *
 * algorithms
 * Medium (57.49%)
 * Likes:    1745
 * Dislikes: 0
 * Total Accepted:    312.2K
 * Total Submissions: 543.1K
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
            if (s.isEmpty()) return "";
            StringBuilder cur = new StringBuilder();
            Stack<String> stringStack = new Stack<>();
            Stack<Integer> countStack = new Stack<>();
            int k = 0;
            for (char ch : s.toCharArray()){
                if (Character.isDigit(ch)){
                    k = k * 10 + ch - '0';
                }else if (ch == '['){
                    countStack.push(k);
                    stringStack.push(cur.toString());
                    // reset cur
                    cur = new StringBuilder();
                    k = 0;
                }else if (ch == ']'){
                    int retryTimes = countStack.pop();
                    StringBuilder tmp = new StringBuilder(stringStack.pop());
                    for (int i = 0; i < retryTimes; i++){
                        tmp.append(cur);
                    }
                    cur = tmp;
                }else{
                    cur.append(ch);
                }
            }
            return cur.toString();
        }
    }
// @lc code=end
}

