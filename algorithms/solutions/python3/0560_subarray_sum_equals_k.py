#
# @lc app=leetcode.cn id=560 lang=python3
#
# [560] Subarray Sum Equals K
#
# https://leetcode.cn/problems/subarray-sum-equals-k/description/
#

# @lc code=start
from collections import defaultdict
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        s = [0] * (len(nums) + 1)
        for i in range(1, len(nums) + 1):
            s[i] = s[i - 1] + nums[i - 1]
        
        res = 0
        cnt = defaultdict(int)
        cnt[0] = 1 # init the initial value
        for sj in s[1:]:
            res = res + cnt[sj - k]
            cnt[sj] += 1
        return res
# @lc code=end

