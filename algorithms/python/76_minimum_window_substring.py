#
# @lc app=leetcode.cn id=76 lang=python3
#
# [76] Minimum Window Substring
#
# https://leetcode.cn/problems/minimum-window-substring/description/
#
# algorithms
# Hard (45.ord('0')%)
# Likes:    2785
# Dislikes: 0
# Total Accepted:    498.6K
# Total Submissions: 1.1M
# Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
#
# Given two strings s and t of lengths m and n respectively, return the minimum
# window substring of s such that every character in t (including duplicates)
# is included in the window. If there is no such substring, return the empty
# string "".
# 
# The testcases will be generated such that the answer is unique.
# 
# 
# Example 1:
# 
# 
# Input: s = "ADOBECODEBANC", t = "ABC"
# Output: "BANC"
# Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
# from string t.
# 
# 
# Example 2:
# 
# 
# Input: s = "a", t = "a"
# Output: "a"
# Explanation: The entire string s is the minimum window.
# 
# 
# Example 3:
# 
# 
# Input: s = "a", t = "aa"
# Output: ""
# Explanation: Both 'a's from t must be included in the window.
# Since the largest window of s only has one 'a', return empty string.
# 
# 
# 
# Constraints:
# 
# 
# m == s.length
# n == t.length
# 1 <= m, n <= 10^5
# s and t consist of uppercase and lowercase English letters.
# 
# 
# 
# Follow up: Could you find an algorithm that runs in O(m + n) time?
# 
#

# @lc code=start
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m, n = len(s), len(t)
        if m < n:
            return ""
        s_array = [0 for _ in range(128)]
        t_array = self.init_array(t)
        left_index = right_index = 0
        left = right = 0
        m_len = float('inf')
        while right < len(s):
            s_array[ord(s[right])] += 1
            right += 1
            while left <= right and self.alphabet_equals(s_array, t_array):
                l = right - left + 1
                if l < m_len:
                    m_len = l
                    left_index = left
                    right_index = right
                s_array[ord(s[left])] -= 1
                left += 1
        return s[left_index: right_index] if m_len != float('inf') else ""
    
    def init_array(self, s: str) -> list:
        res = [0 for _ in range(128)]
        for i in range(len(s)):
            res[ord(s[i])] += 1
        return res
    
    def alphabet_equals(self, s_array, t_array) -> bool:
        for i in range(len(t_array)):
            if t_array[i] == 0: continue
            if t_array[i] - s_array[i] > 0:
                return False
        return True




# @lc code=end

