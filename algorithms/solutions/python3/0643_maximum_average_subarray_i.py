#
# @lc app=leetcode.cn id=643 lang=python3
#
# [643] Maximum Average Subarray I
#
# https://leetcode.cn/problems/maximum-average-subarray-i/description/
#

# @lc code=start
from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        if not nums:
            return 0.0
        sum = 0
        for i in range(k):
            sum += nums[i]
        max_avg = sum / k
        for i in range(k, len(nums)):
            sum = sum + nums[i] - nums[i - k]
            max_avg = max(max_avg, sum / k)
        return max_avg
        
# @lc code=end

