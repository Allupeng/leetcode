/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] Backspace String Compare
 *
 * https://leetcode.cn/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (47.95%)
 * Likes:    637
 * Dislikes: 0
 * Total Accepted:    201.7K
 * Total Submissions: 420.6K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * 
 * 
 * 
 * Follow up: Can you solve it in O(n) time and O(1) space?
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _0844_BackspaceStringCompare{
// @lc code=start
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            if((s == null && t == null) || (s == "" && t == "")){
                return true;
            }
            if(s == null || t == null){
                return false;
            }
            int sPointer = s.length() - 1;
            int tPointer = t.length() - 1;
            while(sPointer >= 0 || tPointer >= 0){
                int sSkip = 0;
                int tSkip = 0;
                while(sPointer >= 0){
                    if(s.charAt(sPointer) == '#'){
                        sSkip++;
                        sPointer--;
                    }else if(sSkip > 0){
                        sSkip--;
                        sPointer--;
                    }else{
                        break;
                    }
                }
                while(tPointer >= 0){
                    if(t.charAt(tPointer) == '#'){
                        tSkip++;
                        tPointer--;
                    }else if(tSkip > 0){
                        tSkip--;
                        tPointer--;
                    }else{
                        break;
                    }
                }
                if(sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)){
                    return false;
                }
                if((sPointer >= 0) != (tPointer >= 0)){
                    return false;
                }
                sPointer--;
                tPointer--;
            }
            return true;
        }
    }
// @lc code=end
    @Test
    public void testBackspaceCompare() {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "ab#c";
        String t1 = "ad#c";
        boolean expected1 = true;
        boolean actual1 = solution.backspaceCompare(s1, t1);
        assertEquals(expected1, actual1);

        // Test case 2
        String s2 = "ab##";
        String t2 = "c#d#";
        boolean expected2 = true;
        boolean actual2 = solution.backspaceCompare(s2, t2);
        assertEquals(expected2, actual2);

        // Test case 3
        String s3 = "a##c";
        String t3 = "#a#c";
        boolean expected3 = true;
        boolean actual3 = solution.backspaceCompare(s3, t3);
        assertEquals(expected3, actual3);

        // Test case 4
        String s4 = "a#c";
        String t4 = "b";
        boolean expected4 = false;
        boolean actual4 = solution.backspaceCompare(s4, t4);
        assertEquals(expected4, actual4);

        // Test case 5
        String s5 = "bxj##tw";
        String t5 = "bxo#j##tw";
        boolean expected5 = false;
        boolean actual5 = solution.backspaceCompare(s5, t5);
        assertEquals(expected5, actual5);
    }
}

