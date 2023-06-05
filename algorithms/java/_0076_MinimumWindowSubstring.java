/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (45.18%)
 * Likes:    2524
 * Dislikes: 0
 * Total Accepted:    426.5K
 * Total Submissions: 943.9K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _0076_MinimumWindowSubstring{
// @lc code=start
    class Solution {
        public String minWindow(String s, String t) {
            int[] sArray = new int[256];
            int[] tArray = initCharArray(t);
            int leftIndex = 0,rightIndex = 0;
            int minLen = Integer.MAX_VALUE;
            int left = 0, right = 0;
            while(right < s.length()){
                sArray[s.charAt(right) - '0']++;
                right++;
                while(left <= right && isAlphabetWork(sArray, tArray)){
                    int len = right - left + 1;
                    if(len < minLen){
                        minLen = len;
                        leftIndex = left;
                        rightIndex = right;
                    }
                    sArray[s.charAt(left) - '0']--;
                    left++;
                }
            }
            return minLen == Integer.MIN_VALUE ? "" : s.substring(leftIndex, rightIndex);
        }

        private int[] initCharArray(String str){
            int[] alphabet = new int[128];
            for(int i = 0; i < str.length(); i++){
                alphabet[str.charAt(i) - '0']++;
            }
            return alphabet;
        }

        private boolean isAlphabetWork(int[] sArray, int[] tArray){
            for(int i = 0; i < tArray.length; i++){
                if (tArray[i] == 0){
                    continue;
                }
                if(tArray[i] - sArray[i] > 0){
                    return false;
                }
            }
            return true;
        }

    }
// @lc code=end

    @Test
    public void testMinWindow() {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String expected1 = "BANC";
        String actual1 = solution.minWindow(s1, t1);
        assertEquals(expected1, actual1);

        // Test case 2
        String s2 = "a";
        String t2 = "a";
        String expected2 = "a";
        String actual2 = solution.minWindow(s2, t2);
        assertEquals(expected2, actual2);

        // Test case 3
        String s3 = "a";
        String t3 = "aa";
        String expected3 = "";
        String actual3 = solution.minWindow(s3, t3);
        assertEquals(expected3, actual3);

        // Test case 4
        String s4 = "aa";
        String t4 = "aa";
        String expected4 = "aa";
        String actual4 = solution.minWindow(s4, t4);
        assertEquals(expected4, actual4);

        // Test case 5
        String s5 = "abc";
        String t5 = "def";
        String expected5 = "";
        String actual5 = solution.minWindow(s5, t5);
        assertEquals(expected5, actual5);

        // Test case 6
        String s6 = "a";
        String t6 = "b";
        String expected6 = "";
        String actual6 = solution.minWindow(s6, t6);
        assertEquals(expected6, actual6);

        // Test case 7
        String s7 = "ab";
        String t7 = "a";
        String expected7 = "a";
        String actual7 = solution.minWindow(s7, t7);
        assertEquals(expected7, actual7);

        // Test case 8
        String s8 = "ab";
        String t8 = "b";
        String expected8 = "b";
        String actual8 = solution.minWindow(s8, t8);
        assertEquals(expected8, actual8);

        // Test case 9
        String s9 = "ab";
        String t9 = "c";
        String expected9 = "";
        String actual9 = solution.minWindow(s9, t9);
        assertEquals(expected9, actual9);

        // Test case 10
        String s10 = "bdab";
        String t10 = "ab";
        String expected10 = "ab";
        String actual10 = solution.minWindow(s10, t10);
        assertEquals(expected10, actual10);
    }
}

