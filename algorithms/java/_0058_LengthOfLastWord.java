/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.cn/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (43.49%)
 * Likes:    638
 * Dislikes: 0
 * Total Accepted:    476.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 * 
 * 
 */

public class _0058_LengthOfLastWord {
// @lc code=start
    class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            int result = 0;
            for (int i = s.length() - 1; i >= 0; i--){
                if (s.charAt(i) == ' '){
                    break;
                }
                result++;
            }
            return result;
        }
    }
// @lc code=end
}

