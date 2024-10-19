
# @lc code=start
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {}
        for i in range(len(nums)):
            another = target - nums[i]
            if another in m:
                return [m[another] , i]
            m[nums[i]] = i
        return [-1, -1]
# @lc code=end

