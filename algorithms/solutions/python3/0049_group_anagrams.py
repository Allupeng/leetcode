
# @lc app=leetcode.cn id=49 lang=python3

# @lc code=start
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if not strs:
            return []
        anagrams_map = {}
        for str in strs:
            sorted_str = ''.join(sorted(str))
            anagrams_list = [] if sorted_str not in anagrams_map else anagrams_map[sorted_str]
            anagrams_list.append(str)
            anagrams_map[sorted_str] = anagrams_list
        res = []
        for _, values in anagrams_map.items():
            res.append(values)
        return res
        
# @lc code=end

