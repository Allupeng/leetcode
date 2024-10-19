#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#
# https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        max_len = 1
        m_set = set()
        left = right = 0
        while right < len(s):
            while s[right] in m_set:
                m_set.remove(s[left])
                left = left + 1
            m_set.add(s[right])
            max_len = max(max_len, right - left + 1)
            right = right + 1
        return max_len
# @lc code=end

