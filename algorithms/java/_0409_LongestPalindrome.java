/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.cn/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (55.72%)
 * Likes:    559
 * Dislikes: 0
 * Total Accepted:    182.9K
 * Total Submissions: 328.3K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string s which consists of lowercase or uppercase letters, return
 * the length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length
 * is 1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * 
 * 
 */

public class _0409_LongestPalindrome {
// @lc code=start
    class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                count[ch - '0']++;
            }
            int res = 0;
            boolean hasOdd = false;
            for (int i = 0; i < count.length; i++){
                res += count[i];
                if (count[i] % 2 == 1){
                    res -= 1;
                    hasOdd = true;
                }
            }
            return hasOdd ? res + 1 : res;
        }
    }
// @lc code=end
}

