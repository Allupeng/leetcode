#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] Validate Binary Search Tree
#
# https://leetcode.cn/problems/validate-binary-search-tree/description/
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
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        def hepler(cur: Optional[TreeNode], lower_bound: int, upper_bound: int):
            if not cur:
                return True
            if not lower_bound < cur.val < upper_bound:
                return False
            return hepler(cur.left, lower_bound, cur.val) and hepler(cur.right, cur.val, upper_bound)
        return hepler(root.left, -sys.maxsize - 1, root.val) and hepler(root.right, root.val, sys.maxsize)
        
# @lc code=end

