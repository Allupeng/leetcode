#
# @lc app=leetcode.cn id=226 lang=python3
#
# [226] Invert Binary Tree
#
# https://leetcode.cn/problems/invert-binary-tree/description/
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
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root
        
# @lc code=end

