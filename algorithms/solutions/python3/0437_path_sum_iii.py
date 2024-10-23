#
# @lc app=leetcode.cn id=437 lang=python3
#
# [437] Path Sum III
#
# https://leetcode.cn/problems/path-sum-iii/description/
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
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if not root:
            return 0
        self.res = 0
        
        # start from cur node
        def dfs(root: Optional[TreeNode], curSum: int):
            if not root:
                return
            curSum += root.val
            if curSum == targetSum:
                self.res += 1
            dfs(root.left, curSum)
            dfs(root.right, curSum)
        
        def findPaths(root: Optional[TreeNode]):
            if not root:
                return
            dfs(root, 0)
            findPaths(root.left)
            findPaths(root.right)
        
        findPaths(root)
        return self.res
            
        
        
# @lc code=end

