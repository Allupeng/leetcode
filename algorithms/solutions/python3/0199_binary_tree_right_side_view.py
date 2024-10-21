#
# @lc app=leetcode.cn id=199 lang=python3
#
# [199] Binary Tree Right Side View
#
# https://leetcode.cn/problems/binary-tree-right-side-view/description/
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
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        res = []
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                cur = queue.pop(0)
                if i == size - 1:
                    res.append(cur.val)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
        return res
                
        
# @lc code=end

