/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (51.79%)
 * Likes:    886
 * Dislikes: 0
 * Total Accepted:    395.4K
 * Total Submissions: 763.5K
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single
 * space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces
 * between two words. The returned string should only have a single space
 * separating the words. Do not include any extra spaces.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 * 
 * 
 * Follow-up: If the string data type is mutable in your language, can you
 * solve it in-place with O(1) extra space?
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _0151_ReverseWordsInAString {
// @lc code=start
    class Solution {
        public String reverseWords(String s) {
            if (s == null){
                return "";
            }
            // remove leading spaces or trailing spaces
            s = s.trim();
            if (s.length() == 0){
                return "";
            }
            List<String> words = new ArrayList<>();
            int left = 0, right = 0;
            while(right < s.length()){
                while(s.charAt(left) == ' '){
                    left++;
                    right++;
                }
                while(right < s.length() && s.charAt(right) != ' '){
                    right++;
                }
                words.add(s.substring(left, right));
                left = right;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = words.size() - 1; i >= 0; i--){
                stringBuilder.append(words.get(i)).append(' ');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
    }
// @lc code=end
    @Test
    public void testReverseWords() {
        Solution solution = new Solution();

        // Test case 1: Normal input
        String input1 = "the sky is blue";
        String expectedOutput1 = "blue is sky the";
        assertEquals(expectedOutput1, solution.reverseWords(input1));

        // Test case 2: Input with leading and trailing spaces
        String input2 = "  hello world  ";
        String expectedOutput2 = "world hello";
        assertEquals(expectedOutput2, solution.reverseWords(input2));

        // Test case 3: Input with multiple spaces between words
        String input3 = "a good   example";
        String expectedOutput3 = "example good a";
        assertEquals(expectedOutput3, solution.reverseWords(input3));

        // Test case 4: Input with only one word
        String input4 = "hello";
        String expectedOutput4 = "hello";
        assertEquals(expectedOutput4, solution.reverseWords(input4));

        // Test case 5: Input with only spaces
        String input5 = "   ";
        String expectedOutput5 = "";
        assertEquals(expectedOutput5, solution.reverseWords(input5));

        // Test case 6: Input is null
        String input6 = null;
        String expectedOutput6 = "";
        assertEquals(expectedOutput6, solution.reverseWords(input6));

        // Test case 7: Input is an empty string
        String input7 = "";
        String expectedOutput7 = "";
        assertEquals(expectedOutput7, solution.reverseWords(input7));
    }
}

