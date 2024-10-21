#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] Binary Tree Level Order Traversal
#
# https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
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
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            t = []
            for _ in range(size):
                cur = queue.pop(0)
                t.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            res.append(t)
        return res 
                
        
# @lc code=end

