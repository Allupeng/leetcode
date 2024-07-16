 /*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (53.46%)
 * Likes:    1430
 * Dislikes: 0
 * Total Accepted:    423.1K
 * Total Submissions: 791.5K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0438_FindAllAnagramsInAString {
// @lc code=start
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) {
                return new ArrayList<>();
            }
            int[] need = new int[26];
            for(char ch : p.toCharArray()){
                need[ch - 'a']++;
            }
            List<Integer> result = new ArrayList<>();
            int left = 0, right = 0;
            int[] windows = new int[26];
            while (right < s.length()) {
                while(right - left + 1 > p.length()){
                    windows[s.charAt(left) - 'a']--;
                    left++;
                }
                windows[s.charAt(right) - 'a']++;
                if (right - left + 1 == p.length() && Arrays.equals(need, windows)) {
                    result.add(left);
                }
                right++;
            }
            return result;
        }
    }
// @lc code=end
}
