#
# @lc app=leetcode.cn id=503 lang=python3
#
# [503] Next Greater Element II
#
# https://leetcode.cn/problems/next-greater-element-ii/description/
#
# algorithms
# Medium (67.93%)
# Likes:    983
# Dislikes: 0
# Total Accepted:    266.5K
# Total Submissions: 392.3K
# Testcase Example:  '[1,2,1]'
#
# Given a circular integer array nums (i.e., the next element of
# nums[nums.length - 1] is nums[0]), return the next greater number for every
# element in nums.
# 
# The next greater number of a number x is the first greater number to its
# traversing-order next in the array, which means you could search circularly
# to find its next greater number. If it doesn't exist, return -1 for this
# number.
# 
# 
# Example 1:
# 
# 
# Input: nums = [1,2,1]
# Output: [2,-1,2]
# Explanation: The first 1's next greater number is 2; 
# The number 2 can't find next greater number. 
# The second 1's next greater number needs to search circularly, which is also
# 2.
# 
# 
# Example 2:
# 
# 
# Input: nums = [1,2,3,4,3]
# Output: [2,3,4,-1,4]
# 
# 
# 
# Constraints:
# 
# 
# 1 <= nums.length <= 10^4
# -10^9 <= nums[i] <= 10^9
# 
# 
#

# @lc code=start
from typing import List
import unittest


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        next_greater_element = [-1] * n
        stack = []
        for i in range(2 * n):
            while stack and nums[stack[-1]] < nums[i % n]:
                next_greater_element[stack.pop()] = nums[i % n]
            if i < n:
                stack.append(i % n)
        return next_greater_element
# @lc code=end

class TestNextGreaterElementII(unittest.TestCase):
    
    def setUp(self):
        self.solution = Solution()
    
    def test_case1(self):
        nums = [1,2,1]
        expected = [2,-1,2]
        self.assertListEqual(self.solution.nextGreaterElements(nums), expected)
        
    def test_case2(self):
        nums = [1,2,3,4,3]
        expected = [2,3,4,-1,4]
        self.assertListEqual(self.solution.nextGreaterElements(nums), expected)