#
# @lc app=leetcode.cn id=438 lang=python3
#
# [438] Find All Anagrams in a String
#
# https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
#

# @lc code=start
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p):
            return []
        need = [0] * 26
        for ch in p:
            need[ord(ch) - ord('a')] += 1
        windows = [0] * 26
        left = right = 0
        res = []
        while right < len(s):
            windows[ord(s[right]) - ord('a')] += 1
            while right - left + 1 > len(p):
                windows[ord(s[left]) - ord('a')] -= 1
                left = left + 1
            if right - left + 1 == len(p) and windows == need:
                res.append(left)
            right = right + 1  
        return res
        
# @lc code=end

