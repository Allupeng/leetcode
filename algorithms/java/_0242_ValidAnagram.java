/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.cn/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (65.82%)
 * Likes:    788
 * Dislikes: 0
 * Total Accepted:    611.2K
 * Total Submissions: 928.5K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * 
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you
 * adapt your solution to such a case?
 * 
 */

public class _0242_ValidAnagram {
// @lc code=start
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null && t == null){
                return true;
            }
            if (s == null || t == null){
                return false;
            }
            if (s.length() != t.length()){
                return false;
            }
            int[] sArray = new int[128];
            int[] tArray = new int[128];
            for (int i = 0; i < s.length(); i++){
                sArray[s.charAt(i) - '0']++;
                tArray[t.charAt(i) - '0']++;
            }
            for (int i = 0; i < sArray.length; i++){
                if (sArray[i] != tArray[i]){
                    return false;
                }
            }
            return true;
        }
    }
// @lc code=end
}

