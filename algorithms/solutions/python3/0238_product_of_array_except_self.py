#
# @lc app=leetcode.cn id=238 lang=python3
#
# [238] Product of Array Except Self
#
# https://leetcode.cn/problems/product-of-array-except-self/description/
#

# @lc code=start
from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        leftProductExceptSelf = [0] * len(nums)
        leftProductExceptSelf[0] = 1
        for i in range(1, len(nums)):
            leftProductExceptSelf[i] = leftProductExceptSelf[i - 1] * nums[i - 1]
        rightProductExceptSelf = [0] * len(nums)
        rightProductExceptSelf[len(nums) - 1] = 1
        for i in range(len(nums) - 2, -1, -1):
            rightProductExceptSelf[i] = rightProductExceptSelf[i + 1] * nums[i + 1]
        res = [0] * len(nums)
        for i in range(len(nums)):
            res[i] = leftProductExceptSelf[i] * rightProductExceptSelf[i]
        return res
        
# @lc code=end

