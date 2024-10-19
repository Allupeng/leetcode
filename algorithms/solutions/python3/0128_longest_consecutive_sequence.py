#
# @lc app=leetcode.cn id=128 lang=python3
#
# [128] Longest Consecutive Sequence
#
# https://leetcode.cn/problems/longest-consecutive-sequence/description/

# @lc code=start
from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_len = 1
        s = set(nums)
        for num in nums:
            if (num - 1) not in s:
                cur_len = 1
                cur_num = num
                while (cur_num + 1) in s:
                    cur_len += 1
                    cur_num += 1
                max_len = max(cur_len, max_len)
        return max_len
                    
            
        
# @lc code=end

