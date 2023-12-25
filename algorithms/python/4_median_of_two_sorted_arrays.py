#
# @lc app=leetcode id=4 lang=python3
#
# [4] Median of Two Sorted Arrays
#
# https://leetcode.com/problems/median-of-two-sorted-arrays/description/
#
# algorithms
# Hard (38.74%)
# Likes:    27028
# Dislikes: 2976
# Total Accepted:    2.3M
# Total Submissions: 6M
# Testcase Example:  '[1,3]\n[2]'
#
# Given two sorted arrays nums1 and nums2 of size m and n respectively, return
# the median of the two sorted arrays.
# 
# The overall run time complexity should be O(log (m+n)).
# 
# 
# Example 1:
# 
# 
# Input: nums1 = [1,3], nums2 = [2]
# Output: 2.00000
# Explanation: merged array = [1,2,3] and median is 2.
# 
# 
# Example 2:
# 
# 
# Input: nums1 = [1,2], nums2 = [3,4]
# Output: 2.50000
# Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
# 
# 
# 
# Constraints:
# 
# 
# nums1.length == m
# nums2.length == n
# 0 <= m <= 1000
# 0 <= n <= 1000
# 1 <= m + n <= 2000
# -10^6 <= nums1[i], nums2[i] <= 10^6
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # first merge the two arrays
        m, n = len(nums1), len(nums2)
        array = []
        i = j = 0
        while i < m and j < n:
            if nums1[i] <= nums2[j]:
                array.append(nums1[i])
                i = i + 1
            else:
                array.append(nums2[j])
                j = j + 1
        while i < m:
            array.append(nums1[i])
            i = i + 1
        while j < n:
            array.append(nums2[j])
            j = j + 1
        # [1, 2] [1]
        # [1, 2] [1, 2]
        odd = ((m + n) % 2 == 1)
        mid = (m + n) // 2
        result = (float)(array[mid]) if odd else (array[mid - 1] + array[mid]) / 2
        return result


# @lc code=end

