#
# @lc app=leetcode.cn id=230 lang=python3
#
# [230] Kth Smallest Element in a BST
#
# https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
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
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.res = 0
        self.cnt = 0
        
        def preorder(root: Optional[TreeNode]):
            if not root:
                return
            preorder(root.left)
            self.cnt += 1
            if self.cnt == k:
                self.res = root.val
            preorder(root.right)
        preorder(root)
        return self.res
        
# @lc code=end

