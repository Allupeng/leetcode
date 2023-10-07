/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (54.39%)
 * Likes:    1285
 * Dislikes: 0
 * Total Accepted:    323.5K
 * Total Submissions: 594.7K
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

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0438_FindAllAnagramsInAString {
// @lc code=start
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int[] need = new int[26];
            int[] window = new int[26];
            for (char pCh : p.toCharArray()){
                need[pCh - 'a']++;
            }
            int left = 0, right = 0;
            while(right < s.length()){
                window[s.charAt(right) - 'a']++;
                while (right - left + 1 > p.length()){
                    window[s.charAt(left) - 'a']--;
                    left++;
                }
                if (((right - left + 1) == p.length()) && Arrays.equals(need, window)){
                    result.add(left);
                }
                right++;
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test(){
        String s = "abcba", p = "ab";
        Solution solution = new Solution();
        solution.findAnagrams(s, p);
    }
}

