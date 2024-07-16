/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.74%)
 * Likes:    10112
 * Dislikes: 0
 * Total Accepted:    2.8M
 * Total Submissions: 7.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class _0003_LongestSubstringWithoutRepeatingCharacters {
// @lc code=start
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) return 0;
            int maxLen = 1;
            Set<Character> set = new HashSet<>();
            int left = 0, right = 0;
            while (right < s.length()) {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
                set.add(s.charAt(right));
                right++;
            }
            return maxLen;
        }
    }
// @lc code=end
}
