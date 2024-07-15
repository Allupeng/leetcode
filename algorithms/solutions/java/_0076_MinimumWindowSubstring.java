package hot100;/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (45.68%)
 * Likes:    2885
 * Dislikes: 0
 * Total Accepted:    560.4K
 * Total Submissions: 1.2M
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

public class _0076_MinimumWindowSubstring {
// @lc code=start
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            int[] need = new int[128];
            for(char ch : t.toCharArray()){
                need[ch - '0']++;
            }
            int[] windows = new int[128];
            int left = 0, right = 0;
            int leftIndex = 0;
            int minLen = Integer.MAX_VALUE;
            while(right < s.length()){
                windows[s.charAt(right) - '0']++;
                while (right - left + 1 >= t.length() && ifAllTInS(windows, need)) {
                    int len = right - left + 1;
                    if (len < minLen) {
                        minLen = len;
                        leftIndex = left;
                    }
                    windows[s.charAt(left) - '0']--;
                    left++;
                }
                right++;
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(leftIndex, leftIndex + minLen);
        }

        private boolean ifAllTInS(int[] windows, int[] need){
            for(int i = 0; i < windows.length; i++){
                if (windows[i] < need[i]) {
                    return false;
                }
            }
            return true;
        }
    }
// @lc code=end
}

