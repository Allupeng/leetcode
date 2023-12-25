/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.cn/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (54.45%)
 * Likes:    299
 * Dislikes: 0
 * Total Accepted:    160.2K
 * Total Submissions: 294.1K
 * Testcase Example:  '"hello"'
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 * 
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
 * lower and upper cases, more than once.
 * 
 * 
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consist of printable ASCII characters.
 * 
 * 
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class _0345_ReverseVowelsOfAString{
// @lc code=start
    class Solution {
        public String reverseVowels(String s) {
            if(s == null || s.equals("")){
                return "";
            }
            Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U')); 
            // double - pointer
            int leftPointer = 0;
            int rightPointer = s.length() - 1;
            char[] chars = s.toCharArray();
            while(leftPointer < rightPointer){
                while(leftPointer < rightPointer && !vowels.contains(s.charAt(leftPointer))) leftPointer++;
                while(leftPointer < rightPointer && !vowels.contains(s.charAt(rightPointer))) rightPointer--;
                swapCharInString(chars, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            } 
            return new String(chars);
        }

        private void swapCharInString(char[] chars, int left, int right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
    }
// @lc code=end

    @Test
    public void testReverseVowelsWithNullString() {
        Solution ReverseVowels = new Solution();
        String result = ReverseVowels.reverseVowels(null);
        assertEquals("", result);
    }
    
    @Test
    public void testReverseVowelsWithEmptyString() {
        Solution ReverseVowels = new Solution();
        String result = ReverseVowels.reverseVowels("");
        assertEquals("", result);
    }
    
    @Test
    public void testReverseVowelsWithNoVowels() {
        Solution ReverseVowels = new Solution();
        String result = ReverseVowels.reverseVowels("bcdfghjklmnpqrstvwxyz");
        assertEquals("bcdfghjklmnpqrstvwxyz", result);
    }
    
    @Test
    public void testReverseVowelsWithOneVowel() {
        Solution ReverseVowels = new Solution();
        String result = ReverseVowels.reverseVowels("a");
        assertEquals("a", result);
    }
    
    @Test
    public void testReverseVowelsWithTwoVowels() {
        Solution ReverseVowels = new Solution();
        String result = ReverseVowels.reverseVowels("ae");
        assertEquals("ea", result);
    }
    
    @Test
    public void testReverseVowelsWithMultipleVowels() {
        Solution ReverseVowels = new Solution();
        String result = ReverseVowels.reverseVowels("hello world");
        assertEquals("hollo werld", result);
    }

}

