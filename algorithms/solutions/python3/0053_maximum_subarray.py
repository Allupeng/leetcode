#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] Maximum Subarray
#
# https://leetcode.cn/problems/maximum-subarray/description/

# @lc code=start
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        cur_sum = nums[0]
        max_sum = nums[0]
        for i in range(1, len(nums)):
            cur_sum = max(cur_sum + nums[i], nums[i])
            max_sum = max(cur_sum, max_sum)
        return max_sum
        
# @lc code=end

