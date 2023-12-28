#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#
# https://leetcode.com/problems/group-anagrams/description/
#
# algorithms
# Medium (67.33%)
# Likes:    17883
# Dislikes: 536
# Total Accepted:    2.4M
# Total Submissions: 3.6M
# Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
#
# Given an array of strings strs, group the anagrams together. You can return
# the answer in any order.
# 
# An Anagram is a word or phrase formed by rearranging the letters of a
# different word or phrase, typically using all the original letters exactly
# once.
# 
# 
# Example 1:
# Input: strs = ["eat","tea","tan","ate","nat","bat"]
# Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
# Example 2:
# Input: strs = [""]
# Output: [[""]]
# Example 3:
# Input: strs = ["a"]
# Output: [["a"]]
# 
# 
# Constraints:
# 
# 
# 1 <= strs.length <= 10^4
# 0 <= strs[i].length <= 100
# strs[i] consists of lowercase English letters.
# 
# 
#

# @lc code=start
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #define a map [key: sorted-str, value: list(str)]
        anagrams = {}
        for i in range(len(strs)):
            sorted_str = ''.join(sorted(strs[i]))
            if sorted_str not in anagrams:
                anagrams[sorted_str] = []
            anagrams[sorted_str].append(strs[i])
        res = []
        for _,k in enumerate(anagrams):
            res.append(anagrams[k])
        return res 

# @lc code=end

