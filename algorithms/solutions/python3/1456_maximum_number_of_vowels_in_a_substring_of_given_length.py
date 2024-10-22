#
# @lc app=leetcode.cn id=1456 lang=python3
#
# [1456] Maximum Number of Vowels in a Substring of Given Length
#
# https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
#

# @lc code=start
class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        if not s:
            return 0
        res = cnt = 0
        vowels = "aeiou"
        for i in range(k):
            if s[i] in vowels:
                cnt += 1
        res = cnt
        for i in range(k, len(s)):
            if s[i] in vowels:
                cnt += 1
            if s[i - k] in vowels:
                cnt -= 1
            res = max(res, cnt)
        return res
# @lc code=end

