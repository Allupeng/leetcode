#
# @lc app=leetcode.cn id=101 lang=python3
#
# [101] Symmetric Tree
#
# https://leetcode.cn/problems/symmetric-tree/description/
#

# @lc code=start
# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        def helper(left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
            if not left and not right:
                return True
            if not left:
                return False
            if not right:
                return False
            return left.val == right.val and helper(left.left, right.right) and helper(left.right, right.left)
        
        return helper(root.left, root.right)
            
        
# @lc code=end

