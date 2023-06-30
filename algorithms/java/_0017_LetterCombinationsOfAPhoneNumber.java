/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (58.08%)
 * Likes:    2503
 * Dislikes: 0
 * Total Accepted:    708.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0017_LetterCombinationsOfAPhoneNumber {
// @lc code=start
    class Solution {

        private final Map<Character, String> lettersMap = buildAPhoneLettersMap();

        public List<String> letterCombinations(String digits) {
            if (digits.equals("")){
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            int k = digits.length();
            combinations(digits, new StringBuilder(), k, result);
            return result;
        }

        private void combinations(String nextDigits, StringBuilder str, int len, List<String> result){
            if (str.length() == len){
                result.add(str.toString());
                return;
            }
            char ch = nextDigits.charAt(0);
            String letters = lettersMap.get(ch);
            for (int i = 0; i < letters.length(); i++){
                str.append(letters.charAt(i));
                combinations(nextDigits.substring(1), str, len, result);
                str.deleteCharAt(str.length() - 1);
            }
        }

        private Map<Character, String> buildAPhoneLettersMap(){
            Map<Character, String> lettersMap = new HashMap<>();
            lettersMap.put('1', "");
            lettersMap.put('2', "abc");
            lettersMap.put('3', "def");
            lettersMap.put('4', "ghi");
            lettersMap.put('5', "jkl");
            lettersMap.put('6', "mno");
            lettersMap.put('7', "pqrs");
            lettersMap.put('8', "tuv");
            lettersMap.put('9', "wxyz");
            return lettersMap;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
    }
}

