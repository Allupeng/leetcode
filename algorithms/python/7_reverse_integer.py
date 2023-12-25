#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#
# https://leetcode.com/problems/reverse-integer/description/
#
# algorithms
# Medium (28.13%)
# Likes:    12269
# Dislikes: 13230
# Total Accepted:    2.9M
# Total Submissions: 10.5M
# Testcase Example:  '123'
#
# Given a signed 32-bit integer x, return x with its digits reversed. If
# reversing x causes the value to go outside the signed 32-bit integer range
# [-2^31, 2^31 - 1], then return 0.
# 
# Assume the environment does not allow you to store 64-bit integers (signed or
# unsigned).
# 
# 
# Example 1:
# 
# 
# Input: x = 123
# Output: 321
# 
# 
# Example 2:
# 
# 
# Input: x = -123
# Output: -321
# 
# 
# Example 3:
# 
# 
# Input: x = 120
# Output: 21
# 
# 
# 
# Constraints:
# 
# 
# -2^31 <= x <= 2^31 - 1
# 
# 
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        netgative = x < 0
        x = abs(x)
        result = 0
        while x != 0:
            pop = x % 10
            x //= 10
            result = result * 10 + pop
        if result < pow(-2, 31) or result > (pow(2,31) - 1):
            return 0
        else:
            return  -result if netgative else result
# @lc code=end

