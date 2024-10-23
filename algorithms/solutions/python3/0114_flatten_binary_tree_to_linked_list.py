#
# @lc app=leetcode.cn id=114 lang=python3
#
# [114] Flatten Binary Tree to Linked List
#
# https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
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
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        self.flatten(root.left)
        self.flatten(root.right)
        right = root.right # store the source right tree
        root.right = root.left
        root.left = None
        
        # find the rightest sub tree
        cur = root
        while cur.right:
            cur = cur.right
        cur.right = right
        
        
# @lc code=end

