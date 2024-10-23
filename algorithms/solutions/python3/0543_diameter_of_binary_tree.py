#
# @lc app=leetcode.cn id=543 lang=python3
#
# [543] Diameter of Binary Tree
#
# https://leetcode.cn/problems/diameter-of-binary-tree/description/
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
    
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.max_diameter = 0
        def height(cur: Optional[TreeNode]) -> int:
            if not cur:
                return 0
            left_height = height(cur.left)
            right_height = height(cur.right)
            self.max_diameter = max(self.max_diameter, left_height + right_height)
            return max(left_height, right_height) + 1
        height(root)
        return self.max_diameter
            
        
        
        
# @lc code=end

