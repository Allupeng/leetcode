package _744_FindSmallestLetterGreaterThanTarget

/*
 * @lc app=leetcode id=744 lang=golang
 *
 * [744] Find Smallest Letter Greater Than Target
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * algorithms
 * Easy (51.59%)
 * Likes:    4274
 * Dislikes: 2181
 * Total Accepted:    446.9K
 * Total Submissions: 866.3K
 * Testcase Example:  '["c","f","j"]\n"a"'
 *
 * You are given an array of characters letters that is sorted in
 * non-decreasing order, and a character target. There are at least two
 * different characters in letters.
 *
 * Return the smallest character in letters that is lexicographically greater
 * than target. If such a character does not exist, return the first character
 * in letters.
 *
 *
 * Example 1:
 *
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Explanation: The smallest character that is lexicographically greater than
 * 'a' in letters is 'c'.
 *
 *
 * Example 2:
 *
 *
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Explanation: The smallest character that is lexicographically greater than
 * 'c' in letters is 'f'.
 *
 *
 * Example 3:
 *
 *
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: "x"
 * Explanation: There are no characters in letters that is lexicographically
 * greater than 'z' so we return letters[0].
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= letters.length <= 10^4
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 *
 *
 */

// @lc code=start
func nextGreatestLetter(letters []byte, target byte) byte {
	lo, hi := 0, len(letters)-1
	for lo <= hi {
		mid := lo + (hi-lo)>>1
		if target < letters[mid] {
			hi = mid - 1
		} else if target > letters[mid] {
			lo = mid + 1
		} else {
			lo = mid + 1
		}
	}
	if lo >= len(letters) {
		return letters[0]
	}
	return letters[lo]
}

// @lc code=end
