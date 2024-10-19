#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] Container With Most Water
#
# https://leetcode.cn/problems/container-with-most-water/description/


# @lc code=start
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        left = 0
        right = len(height) - 1
        while left < right:
            h = min(height[left], height[right])
            w = right - left
            res = max(res, w * h)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return res
        
# @lc code=end

