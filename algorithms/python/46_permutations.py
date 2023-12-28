#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#
# https://leetcode.com/problems/permutations/description/
#
# algorithms
# Medium (77.63%)
# Likes:    18356
# Dislikes: 296
# Total Accepted:    1.9M
# Total Submissions: 2.4M
# Testcase Example:  '[1,2,3]'
#
# Given an array nums of distinct integers, return all the possible
# permutations. You can return the answer in any order.
# 
# 
# Example 1:
# Input: nums = [1,2,3]
# Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
# Example 2:
# Input: nums = [0,1]
# Output: [[0,1],[1,0]]
# Example 3:
# Input: nums = [1]
# Output: [[1]]
# 
# 
# Constraints:
# 
# 
# 1 <= nums.length <= 6
# -10 <= nums[i] <= 10
# All the integers of nums are unique.
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        used = [False] * len(nums)
        self.backtrace(res, [], used, nums)
        return res

    def backtrace(self, res, cur_list, used, nums):
        if len(cur_list) == len(nums):
            res.append(cur_list.copy())
            return
        for i in range(len(nums)):
            if used[i]:
                continue
            used[i] = True
            self.backtrace(res, cur_list + [nums[i]], used, nums)
            used[i] = False
        
# @lc code=end

