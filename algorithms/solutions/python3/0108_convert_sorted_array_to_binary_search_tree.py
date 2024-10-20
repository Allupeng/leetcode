#
# @lc app=leetcode.cn id=108 lang=python3
#
# [108] Convert Sorted Array to Binary Search Tree
#
# https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
#

# @lc code=start
# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums:
            return None
        return self.buildBST(nums, 0, len(nums) - 1)
        
    def buildBST(self, nums: List[int], left: int, right: int) -> Optional[TreeNode]:
        if left > right:
            return None
        mid = left + ((right - left) >> 1)
        root = TreeNode(nums[mid])
        root.left = self.buildBST(nums, left, mid - 1)
        root.right = self.buildBST(nums, mid + 1, right)
        return root
        
# @lc code=end

