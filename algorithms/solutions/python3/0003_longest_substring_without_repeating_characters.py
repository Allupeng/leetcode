#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#
# https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
#
# algorithms
# Medium (39.95%)
# Likes:    10215
# Dislikes: 0
# Total Accepted:    2.9M
# Total Submissions: 7.3M
# Testcase Example:  '"abcabcbb"'
#
# Given a string s, find the length of the longest substring without repeating
# characters.
# 
# 
# Example 1:
# 
# 
# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.
# 
# 
# Example 2:
# 
# 
# Input: s = "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
# 
# 
# Example 3:
# 
# 
# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
# Notice that the answer must be a substring, "pwke" is a subsequence and not a
# substring.
# 
# 
# 
# Constraints:
# 
# 
# 0 <= s.length <= 5 * 10^4
# s consists of English letters, digits, symbols and spaces.
# 
# 
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = right = 0
        m_set = set()
        max_len = 0
        while right < len(s):
            while s[right] in m_set:
                m_set.remove(s[left])
                left = left + 1
            max_len = max(max_len, right - left + 1)
            m_set.add(s[right])
            right = right + 1
        return max_len
            
# @lc code=end

