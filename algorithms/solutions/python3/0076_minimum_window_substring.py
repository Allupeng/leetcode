#
# @lc app=leetcode.cn id=76 lang=python3
#
# [76] Minimum Window Substring
#
# https://leetcode.cn/problems/minimum-window-substring/description/
#

# @lc code=start
import sys


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = [0] * 128
        for _, v in enumerate(t):
            need[ord(v) - ord('0')] += 1
        min_len = sys.maxsize
        left_index = 0
        left = right = 0
        windows = [0] * 128
        while right < len(s):
            windows[ord(s[right]) - ord('0')] += 1
            while right - left + 1 >= len(t) and self.ifAllTInS(need, windows):
                if min_len > right - left + 1:
                    min_len = right - left + 1
                    left_index = left
                windows[ord(s[left]) - ord('0')] -= 1
                left += 1
            right += 1
        return "" if min_len == sys.maxsize else s[left_index : left_index + min_len]
    
    def ifAllTInS(self, need, windows) -> bool:
        for i in range(len(windows)):
            if need[i] - windows[i] > 0:
                return False
        return True
        
# @lc code=end

