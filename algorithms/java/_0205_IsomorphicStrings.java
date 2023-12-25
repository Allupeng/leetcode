/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.cn/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (49.65%)
 * Likes:    650
 * Dislikes: 0
 * Total Accepted:    222.7K
 * Total Submissions: 448.5K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _0205_IsomorphicStrings {
// @lc code=start
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()){
                return false;
            }
            Map<Character, Character> charMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++){
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (charMap.containsKey(c1)){
                    if (charMap.get(c1) != c2){
                        return false;
                    }
                }else {
                    // no two chars map to same char
                    if (charMap.containsValue(c2)){
                        return false;
                    }
                    charMap.put(c1, c2);
                }
            }
            return true;
        }
    }
// @lc code=end

    @Test
    public void test(){
        String s = "foo", t = "bar";
        Solution solution = new Solution();
        Assert.assertTrue(solution.isIsomorphic(s, t));
    }
}
