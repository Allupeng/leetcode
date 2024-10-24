#
# @lc app=leetcode.cn id=303 lang=python3
#
# [303] Range Sum Query - Immutable
#
# https://leetcode.cn/problems/range-sum-query-immutable/description/
#

# @lc code=start
from typing import List


class NumArray:
    pre_sum = []
    def __init__(self, nums: List[int]):
      self.pre_sum = [0] * (len(nums) + 1)
      for i in range(1, len(nums) + 1):
        self.pre_sum[i] = self.pre_sum[i - 1] + nums[i - 1]      

    def sumRange(self, left: int, right: int) -> int:
      return self.pre_sum[right + 1] - self.pre_sum[left]
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
# @lc code=end

