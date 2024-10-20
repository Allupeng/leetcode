#
# @lc app=leetcode.cn id=41 lang=python3
#
# [41] First Missing Positive
#
# https://leetcode.cn/problems/first-missing-positive/description/
#

# @lc code=start
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # nums[i] = i + 1 --> i = nums[i] - 1
        for i in range(len(nums)):
            while nums[i] > 0 and nums[i] <= len(nums) and nums[nums[i] - 1] != nums[i]:
                t = nums[i] - 1
                nums[t], nums[i] = nums[i], nums[t]
        
        for i in range(len(nums)):
            if nums[i] != i + 1:
                return i + 1
        
        return len(nums) + 1
        
# @lc code=end

