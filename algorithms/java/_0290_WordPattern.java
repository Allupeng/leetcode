/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.cn/problems/word-pattern/description/
 *
 * algorithms
 * Easy (44.52%)
 * Likes:    606
 * Dislikes: 0
 * Total Accepted:    146.1K
 * Total Submissions: 328.1K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _0290_WordPattern {
// @lc code=start
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strings = s.split(" ");
            if (pattern.length() != strings.length){
                return false;
            }
            Map<Character, String> map = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++){
                char p = pattern.charAt(i);
                String t = strings[i];
                if (map.containsKey(p)){
                    if (!map.get(p).equals(t)){
                        return false;
                    }
                }else {
                    if (map.containsValue(t)){
                        return false;
                    }
                    map.put(p, t);
                }
            }
            return true;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        String pattern = "abba", s = "dog cat cat fish";
        Assert.assertFalse(solution.wordPattern(pattern, s));
    }
}

