/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.cn/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (58.10%)
 * Likes:    474
 * Dislikes: 0
 * Total Accepted:    204.3K
 * Total Submissions: 351.7K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * Given a string s and an integer k, reverse the first k characters for every
 * 2k characters counting from the start of the string.
 * 
 * If there are fewer than k characters left, reverse all of them. If there are
 * less than 2k but greater than or equal to k characters, then reverse the
 * first k characters and leave the other as original.
 * 
 * 
 * Example 1:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^4
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0541_ReverseStringIi {
// @lc code=start
    class Solution {
        public String reverseStr(String s, int k) {
            if (s == null || s.length() == 0){
                return "";
            }
            // split s into n * 2k;
            List<String> splitS = new ArrayList<>();
            int n = s.length() / (2 * k);
            for(int i = 0; i < n; i++){
                splitS.add(s.substring(i * 2*k, (i + 1) * (2 * k)));
            }
            splitS.add(s.substring(n * 2 * k));
            StringBuilder result = new StringBuilder();
            for (String split : splitS){
                result.append(reversePartialStr(split, k));
            }
            return result.toString();
        }

        private String reversePartialStr(String str, int k){
            char[] s = str.toCharArray();
            if(str.length() < k){
                // reverse all characters
                int left = 0, right = s.length - 1;
                while(left < right){
                    swap(s, left, right);
                    left++;
                    right--;
                }
            }else {
                // reverse k characters
                int left = 0, right = k - 1;
                while(left < right){
                    swap(s, left, right);
                    left++;
                    right--;
                }
            }
            return new String(s);
        }

        private void swap(char[] s, int left, int right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
// @lc code=end
}

