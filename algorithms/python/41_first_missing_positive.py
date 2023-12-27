#
# @lc app=leetcode id=41 lang=python3
#
# [41] First Missing Positive
#
# https://leetcode.com/problems/first-missing-positive/description/
#
# algorithms
# Hard (37.51%)
# Likes:    15514
# Dislikes: 1735
# Total Accepted:    993.9K
# Total Submissions: 2.6M
# Testcase Example:  '[1,2,0]'
#
# Given an unsorted integer array nums, return the smallest missing positive
# integer.
# 
# You must implement an algorithm that runs in O(n) time and uses O(1)
# auxiliary space.
# 
# 
# Example 1:
# 
# 
# Input: nums = [1,2,0]
# Output: 3
# Explanation: The numbers in the range [1,2] are all in the array.
# 
# 
# Example 2:
# 
# 
# Input: nums = [3,4,-1,1]
# Output: 2
# Explanation: 1 is in the array but 2 is missing.
# 
# 
# Example 3:
# 
# 
# Input: nums = [7,8,9,11,12]
# Output: 1
# Explanation: The smallest positive integer 1 is missing.
# 
# 
# 
# Constraints:
# 
# 
# 1 <= nums.length <= 10^5
# -2^31 <= nums[i] <= 2^31 - 1
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            while 0 < nums[i] < len(nums) and nums[nums[i] - 1] != nums[i]:
                if nums[i] - 1 != i:  # 确保不在同一位置进行交换
                    nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
                else:
                    break
        for i in range(len(nums)):
            if nums[i] != i + 1:
                return i + 1
        return len(nums) + 1

        
# @lc code=end

