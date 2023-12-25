/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] Find the Index of the First Occurrence in a String
 *
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 * algorithms
 * Medium (42.43%)
 * Likes:    1880
 * Dislikes: 0
 * Total Accepted:    853.9K
 * Total Submissions: 2M
 * Testcase Example:  '"sadbutsad"\n"sad"'
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 * 
 * 
 */

public class _0028_FindTheIndexOfTheFirstOccurrenceInAString {
// @lc code=start
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack.equals("")){
                return -1;
            }
            // i point to haystack, j point to needle
            int i = 0, j = 0;
            int[] lsp = buildLsp(needle);
            while(i < haystack.length()){
                if(haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                    if (j == needle.length()){
                        return i - j;
                    }
                }else if (j > 0){
                    // skip suffix strings
                    j = lsp[j - 1];
                }else {
                    i++;
                }
            }
            return -1;
        }

        // build kmp lsp array
        private int[] buildLsp(String pattern){
            int[] lsp = new int[pattern.length()];
            int j = 0, i = 1;
            lsp[0] = 0;
            while(i < pattern.length()){
                if (pattern.charAt(j) == pattern.charAt(i)){
                    // move forward
                    lsp[i] = j + 1;
                    i++;
                    j++;
                }else if(j > 0){
                    // traceback to next suffix or prefix str
                    j = lsp[j - 1];
                }else{
                    // compare next character
                    i++;
                }
            }
            return lsp;
        }
    }
// @lc code=end
}

