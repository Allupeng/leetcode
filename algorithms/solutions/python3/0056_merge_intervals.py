#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] Merge Intervals
#
# https://leetcode.cn/problems/merge-intervals/description/
#

# @lc code=start
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        intervals.sort(key=lambda x :(x[0], x[1]))
        l = []
        l.append(intervals[0])
        for i in range(1, len(intervals)):
            prev = l[len(l) - 1]
            cur = intervals[i]
            # [1, 3] [2, 4]
            if cur[0] <= prev[1]:
                # [1, 4] [2, 4]
                if cur[1] <= prev[1]:
                    # do nothing
                    pass
                else:
                    l.pop()
                    l.append([prev[0], cur[1]])
            else:
                l.append(cur)
        return l
                    
                    
        
# @lc code=end

