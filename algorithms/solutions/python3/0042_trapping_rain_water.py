#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] Trapping Rain Water
#
# https://leetcode.cn/problems/trapping-rain-water/description/
#

# @lc code=start
from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        total = 0
        left_max_dp = [0] * len(height)
        for i in range(1, len(height)):
            left_max_dp[i] = max(left_max_dp[i - 1], height[i - 1])
        right_max_dp = [0] * len(height)
        for i in range(len(height) - 2, -1, -1):
            right_max_dp[i] = max(right_max_dp[i + 1], height[i + 1])
        for i in range(1, len(height) - 1):
            h = min(left_max_dp[i], right_max_dp[i])
            if h - height[i] > 0:
                total = total + (h - height[i])
        return total
        
# @lc code=end

