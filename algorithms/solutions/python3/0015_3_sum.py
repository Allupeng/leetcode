#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 3Sum
#
# https://leetcode.cn/problems/3sum/description/
#

# @lc code=start
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        nums.sort()
        res = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left = i + 1
            right = len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum == 0:
                    res.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left = left + 1
                    while left < right and nums[right] == nums[right - 1]:
                        right = right - 1
                    left = left + 1
                    right = right - 1
                elif sum < 0:
                    left = left + 1
                else:
                    right = right - 1
        return res  
                
        
# @lc code=end

