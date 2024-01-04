#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] Search a 2D Matrix
#
# https://leetcode.cn/problems/search-a-2d-matrix/description/
#
# algorithms
# Medium (49.19%)
# Likes:    885
# Dislikes: 0
# Total Accepted:    355.4K
# Total Submissions: 722.5K
# Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
#
# You are given an m x n integer matrix matrix with the following two
# properties:
# 
# 
# Each row is sorted in non-decreasing order.
# The first integer of each row is greater than the last integer of the
# previous row.
# 
# 
# Given an integer target, return true if target is in matrix or false
# otherwise.
# 
# You must write a solution in O(log(m * n)) time complexity.
# 
# 
# Example 1:
# 
# 
# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
# Output: true
# 
# 
# Example 2:
# 
# 
# Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
# Output: false
# 
# 
# 
# Constraints:
# 
# 
# m == matrix.length
# n == matrix[i].length
# 1 <= m, n <= 100
# -10^4 <= matrix[i][j], target <= 10^4
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        if m == 0 or n == 0: return False
        array = []
        for i in range(m):
            for j in range(n):
                array.append(matrix[i][j])
        return self.b_search(array, target)
    
    def b_search(self, array, target) -> bool:
        lo, hi = 0, len(array) - 1
        while lo <= hi:
            m = lo + ((hi - lo) >> 1)
            if target < array[m]:
                hi = m - 1
            elif array[m] < target:
                lo = m + 1
            else:
                if m == 0 or array[m - 1] != array[m]:
                    return True
                else:
                    hi = m - 1
        return False


# @lc code=end
