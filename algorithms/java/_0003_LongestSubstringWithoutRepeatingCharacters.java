/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.17%)
 * Likes:    9484
 * Dislikes: 0
 * Total Accepted:    2.4M
 * Total Submissions: 6.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class _0003_LongestSubstringWithoutRepeatingCharacters {
    // @lc code=start
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.equals("")){
                return 0;
            }
            int result = 0;
            Set<Character> set = new HashSet<>();
            //滑动窗口算法
            int left = 0, right = 0;
            while(right < s.length()){
                // 如果滑动窗口包含重复值，更新最大长度。
                if (set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }else {
                    set.add(s.charAt(right));
                    result = Math.max(right - left + 1, result);
                    right++;
                }
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        String str1 = "abcabcbb";
        Assert.assertEquals(3, solution.lengthOfLongestSubstring(str1));

        String str2 = "pwwkew";
        Assert.assertEquals(3, solution.lengthOfLongestSubstring(str2));

        String str3 = " a";
        Assert.assertEquals(2, solution.lengthOfLongestSubstring(str3));

        String str4 = "dvdf";
        Assert.assertEquals(3, solution.lengthOfLongestSubstring(str4));
    }
}

