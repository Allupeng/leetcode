/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.cn/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (46.54%)
 * Likes:    694
 * Dislikes: 0
 * Total Accepted:    509.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class _0125_ValidPalindrome {
// @lc code=start
    class Solution {
        public boolean isPalindrome(String s) {
            s = pureString(s);
            int left = 0, right = s.length() - 1;
            while (left < right){
                while (!Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) left++;
                while (!Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) right--;
                if (s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        private String pureString(String str){
            str = str.trim().toLowerCase();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if (Character.isAlphabetic(ch) || Character.isDigit(ch)){
                    result.append(ch);
                }
            }
            return result.toString();
        }
    }
// @lc code=end

    @Test
    public void test(){
        String s = ".,";
        Solution solution = new Solution();
        Assert.assertTrue(solution.isPalindrome(s));
    }
}

