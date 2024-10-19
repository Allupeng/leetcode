#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] Move Zeroes
#
# https://leetcode.cn/problems/move-zeroes/description/
#

# @lc code=start
from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left = right = 0
        while right < len(nums):
            if nums[right] != 0:
                if left != right:
                    nums[left], nums[right] = nums[right], nums[left]
                left += 1
            right += 1
                    
        
# @lc code=end

