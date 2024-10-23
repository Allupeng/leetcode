#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
#
# https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
#

# @lc code=start
# Definition for a binary tree node.
from typing import List, Optional


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
        
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.preIndex = 0
        return self.buildTreeCore(preorder, inorder, 0, len(inorder) - 1)
        
    def buildTreeCore(self, preorder: List[int], inorder: List[int], inorder_left: int, inorder_right: int) -> Optional[TreeNode]:
        if inorder_left > inorder_right:
            return None
        root_val = preorder[self.preIndex]
        self.preIndex += 1
        inorder_index = self.findIndexFromList(root_val, inorder)
        root = TreeNode(root_val)
        root.left = self.buildTreeCore(preorder, inorder, inorder_left, inorder_index - 1)
        root.right = self.buildTreeCore(preorder, inorder, inorder_index + 1, inorder_right)
        return root
        
        
    def findIndexFromList(self, value: int, list: List[int]) -> int:
        for i in range(len(list)):
            if list[i] == value:
                return i
        return -1
        
# @lc code=end

