#
# @lc app=leetcode.cn id=124 lang=python3
#
# [124] Binary Tree Maximum Path Sum
#
# https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
#

# @lc code=start
# Definition for a binary tree node.
import sys
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.res = -sys.maxsize - 1
        
        def pathSum(root: Optional[TreeNode]) -> int:
            if not root:
                return 0
            left_sum = max(pathSum(root.left), 0)
            right_sum = max(pathSum(root.right), 0)
            self.res = max(self.res, left_sum + root.val + right_sum)
            return max(left_sum, right_sum) + root.val
            
        pathSum(root)
        return self.res
        
# @lc code=end

