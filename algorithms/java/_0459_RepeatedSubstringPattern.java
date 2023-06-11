/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.cn/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (51.18%)
 * Likes:    978
 * Dislikes: 0
 * Total Accepted:    190.8K
 * Total Submissions: 372.7K
 * Testcase Example:  '"abab"'
 *
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aba"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc"
 * twice.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0459_RepeatedSubstringPattern {
// @lc code=start
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int[] lsp = buildLsp(s);
            int len = s.length();
            return lsp[len - 1] > 0 && len % (len - lsp[len - 1]) == 0;
        }

        private int[] buildLsp(String pattern){
            int[] lsp = new int[pattern.length()];
            lsp[0] = 0;
            int j = 0, i = 1;
            while(i < pattern.length()){
                if(pattern.charAt(i) == pattern.charAt(j)){
                    lsp[i] = j + 1;
                    i++;
                    j++;
                }else if(j > 0){
                    j = lsp[j - 1];
                }else{
                    i++;
                }
            }
            return lsp;
        }
    }
// @lc code=end
    @Test
    public void test1(){
        String s = "abac";
        Solution solution = new Solution();
        Assert.assertFalse(solution.repeatedSubstringPattern(s));
    }
}

