#
# @lc app=leetcode.cn id=739 lang=python3
#
# [739] Daily Temperatures
#
# https://leetcode.cn/problems/daily-temperatures/description/
#
# algorithms
# Medium (68.76%)
# Likes:    1780
# Dislikes: 0
# Total Accepted:    574.7K
# Total Submissions: 835K
# Testcase Example:  '[73,74,75,71,69,72,76,73]'
#
# Given an array of integers temperatures represents the daily temperatures,
# return an array answer such that answer[i] is the number of days you have to
# wait after the i^th day to get a warmer temperature. If there is no future
# day for which this is possible, keep answer[i] == 0 instead.
# 
# 
# Example 1:
# Input: temperatures = [73,74,75,71,69,72,76,73]
# Output: [1,1,4,2,1,1,0,0]
# Example 2:
# Input: temperatures = [30,40,50,60]
# Output: [1,1,1,0]
# Example 3:
# Input: temperatures = [30,60,90]
# Output: [1,1,0]
# 
# 
# Constraints:
# 
# 
# 1 <= temperatures.length <= 10^5
# 30 <= temperatures[i] <= 100
# 
# 
#
from typing import List
import unittest


# @lc code=start
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        result = [0] * n
        stack = []
        for i, temperature in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temperature:
                prev_index = stack.pop()
                result[prev_index] = i - prev_index
            stack.append(i)
        return result
                
        
# @lc code=end

class TestDailyTemperatures(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_case1(self):
        temperatures = [73,74,75,71,69,72,76,73]
        expected = [1,1,4,2,1,1,0,0]
        self.assertListEqual(self.solution.dailyTemperatures(temperatures), expected)

    def test_case2(self):
        temperatures = [30,40,50,60]
        expected = [1,1,1,0]
        self.assertListEqual(self.solution.dailyTemperatures(temperatures), expected)
    
    def test_case3(self):
        temperatures = [30,60,90]
        expected = [1,1,0]
        self.assertListEqual(self.solution.dailyTemperatures(temperatures), expected)


