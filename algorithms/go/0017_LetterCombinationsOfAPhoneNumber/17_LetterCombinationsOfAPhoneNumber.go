package _017_LetterCombinationsOfAPhoneNumber

import "strings"

/*
 * @lc app=leetcode.cn id=17 lang=golang
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (59.07%)
 * Likes:    2758
 * Dislikes: 0
 * Total Accepted:    813.5K
 * Total Submissions: 1.4M
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

// @lc code=start
func letterCombinations(digits string) []string {
	if strings.EqualFold("", digits) {
		return []string{}
	}
	characters := initMap()
	result := make([]string, 0)
	backtrace(digits, "", len(digits), &result, characters)
	return result
}

func backtrace(nextDigits string, cur string, size int, result *[]string, characters map[string]string) {
	if len(cur) == size {
		*result = append(*result, cur)
		return
	}
	ch := nextDigits[0]
	str := characters[string(ch)]
	for _, v := range str {
		backtrace(nextDigits[1:], cur+string(v), size, result, characters)
	}
}

func initMap() map[string]string {
	result := make(map[string]string)
	result["2"] = "abc"
	result["3"] = "def"
	result["4"] = "ghi"
	result["5"] = "jkl"
	result["6"] = "mno"
	result["7"] = "pqrs"
	result["8"] = "tuv"
	result["9"] = "wxyz"
	return result
}

// @lc code=end
