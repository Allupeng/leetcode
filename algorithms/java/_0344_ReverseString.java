/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.cn/problems/reverse-string/description/
 *
 * algorithms
 * Easy (79.66%)
 * Likes:    776
 * Dislikes: 0
 * Total Accepted:    750.7K
 * Total Submissions: 942.5K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 * 
 * 
 */

public class _0344_ReverseString {
    // @lc code=start
    class Solution {
        public void reverseString(char[] s) {
            if (s == null || s.length <= 0){
                return;
            }
            int left = 0, right = s.length - 1;
            while(left < right){
                swap(s, left, right);
                left++;
                right--;
            }
        }

        private void swap(char[] s, int left, int right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
// @lc code=end
}

