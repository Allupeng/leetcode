/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (73.43%)
 * Likes:    1544
 * Dislikes: 0
 * Total Accepted:    300.7K
 * Total Submissions: 409.6K
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

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0131_PalindromePartitioning {
// @lc code=start
    class Solution {
        private final List<List<String>> result = new ArrayList<>();

        private List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            if (s == null || s.equals("")){
                return result;
            }
            backtrace(s, 0);
            return result;
        }

        private void backtrace(String s, int start){
            if (start == s.length()){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < s.length(); i++){
                if (!isPalindrome(s, start, i)){
                    continue;
                }
                path.add(s.substring(start, i + 1));
                backtrace(s, i + 1);
                path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int start, int end){
            if (start > end){
                return false;
            }
            for (int i = start, j = end; i <= j; i++, j--){
                if (s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        List<List<String>> partition = solution.partition("aab");
        System.out.println(partition);
    }
}

