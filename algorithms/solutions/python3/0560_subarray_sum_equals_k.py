#
# @lc app=leetcode.cn id=560 lang=python3
#
# [560] Subarray Sum Equals K
#
# https://leetcode.cn/problems/subarray-sum-equals-k/description/
#

# @lc code=start
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        pre_sum = [0] * (len(nums) + 1)
        for i in range(1, len(nums) + 1):
            pre_sum[i] = pre_sum[i - 1] + nums[i - 1]
        
        cnt = 0
        for i in range(len(nums)):
            for j in range(i + 1):
                if k == pre_sum[i + 1] - pre_sum[j]:
                    cnt = cnt + 1
        
        return cnt
# @lc code=end

