#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] Subsets
#
# https://leetcode.cn/problems/subsets/description/
#
# algorithms
# Medium (81.16%)
# Likes:    2218
# Dislikes: 0
# Total Accepted:    713K
# Total Submissions: 878.5K
# Testcase Example:  '[1,2,3]'
#
# Given an integer array nums of unique elements, return all possible subsets
# (the power set).
# 
# The solution set must not contain duplicate subsets. Return the solution in
# any order.
# 
# 
# Example 1:
# 
# 
# Input: nums = [1,2,3]
# Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
# 
# 
# Example 2:
# 
# 
# Input: nums = [0]
# Output: [[],[0]]
# 
# 
# 
# Constraints:
# 
# 
# 1 <= nums.length <= 10
# -10 <= nums[i] <= 10
# All the numbers of nums are unique.
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtrace(nums, 0, [], res)
        return res

    def backtrace(self, nums: list, index: int, path: list, res: list):
        res.append(path.copy())
        if index > len(nums):
            return
        for i in range(index, len(nums)):
            self.backtrace(nums, i + 1, path + [nums[i]], res)
        

# @lc code=end

