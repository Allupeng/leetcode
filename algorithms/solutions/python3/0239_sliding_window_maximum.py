#
# @lc app=leetcode.cn id=239 lang=python3
#
# [239] Sliding Window Maximum
#
# https://leetcode.cn/problems/sliding-window-maximum/description/

# @lc code=start
from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = [0] * (n - k + 1)
        windows = deque()
        for i in range(len(nums)):
            while windows and windows[0] < i - k + 1:
                windows.popleft()
            while windows and nums[windows[-1]] < nums[i]:
                windows.pop()
            windows.append(i)
            if windows and i - k + 1 >= 0:
                res[i - k + 1] = nums[windows[0]]
        return res
        
# @lc code=end

