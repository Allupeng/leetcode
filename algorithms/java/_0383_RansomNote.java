/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.cn/problems/ransom-note/description/
 *
 * algorithms
 * Easy (60.53%)
 * Likes:    733
 * Dislikes: 0
 * Total Accepted:    341.5K
 * Total Submissions: 564.3K
 * Testcase Example:  '"a"\n"b"'
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * 
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * 
 */

public class _0383_RansomNote {
// @lc code=start
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote == null && magazine == null){
                return true;
            }
            if (ransomNote == null || magazine == null){
                return false;
            }
            int[] dict = new int[128];
            for(int i = 0; i < magazine.length(); i++){
                dict[magazine.charAt(i) - '0']++;
            }
            int[] ransomNoteChars = new int[128];
            for (int i = 0; i < ransomNote.length(); i++){
                ransomNoteChars[ransomNote.charAt(i) - '0']++;
            }
            for(int i = 0; i < dict.length; i++){
                if (ransomNoteChars[i] > dict[i]){
                    return false;
                }
            }
            return true;
        }
    }
// @lc code=end
}

