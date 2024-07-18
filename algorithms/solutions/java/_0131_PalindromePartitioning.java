/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (73.50%)
 * Likes:    1776
 * Dislikes: 0
 * Total Accepted:    395.4K
 * Total Submissions: 538K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome. Return all possible palindrome partitioning of s.
 * 
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0131_PalindromePartitioning {
// @lc code=start
    class Solution {
        public List<List<String>> partition(String s) {
            if (s.isEmpty()) return new ArrayList<>();
            List<List<String>> result = new ArrayList<>();
            backtrace(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrace(String s, int startIndex, List<String> list, List<List<String>> result){
            if (startIndex == s.length()){
                result.add(new ArrayList<>(list));
                return;
            }
            for (int end = startIndex; end < s.length(); end++){
                if (isPalindrome(s, startIndex, end)){
                    list.add(s.substring(startIndex, end + 1));
                    backtrace(s, end + 1, list, result);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end){
            while (start < end){
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
// @lc code=end
}

