#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] Rotate Array
#
# https://leetcode.cn/problems/rotate-array/description/
#

# @lc code=start
from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(nums, left, right):
            while left <= right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1
        n = len(nums)
        k = k % n
        reverse(nums, 0, n - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, n - 1)
        
# @lc code=end

