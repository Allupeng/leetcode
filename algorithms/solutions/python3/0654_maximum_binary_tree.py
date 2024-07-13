#
# @lc app=leetcode.cn id=654 lang=python3
#
# [654] Maximum Binary Tree
#
# https://leetcode.cn/problems/maximum-binary-tree/description/
#
# algorithms
# Medium (82.08%)
# Likes:    793
# Dislikes: 0
# Total Accepted:    259.4K
# Total Submissions: 316K
# Testcase Example:  '[3,2,1,6,0,5]'
#
# You are given an integer array nums with no duplicates. A maximum binary tree
# can be built recursively from nums using the following algorithm:
# 
# 
# Create a root node whose value is the maximum value in nums.
# Recursively build the left subtree on the subarray prefix to the left of the
# maximum value.
# Recursively build the right subtree on the subarray suffix to the right of
# the maximum value.
# 
# 
# Return the maximum binary tree built from nums.
# 
# 
# Example 1:
# 
# 
# Input: nums = [3,2,1,6,0,5]
# Output: [6,3,5,null,2,0,null,null,1]
# Explanation: The recursive calls are as follow:
# - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right
# suffix is [0,5].
# ⁠   - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix
# is [2,1].
# ⁠       - Empty array, so no child.
# ⁠       - The largest value in [2,1] is 2. Left prefix is [] and right suffix
# is [1].
# ⁠           - Empty array, so no child.
# ⁠           - Only one element, so child is a node with value 1.
# ⁠   - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is
# [].
# ⁠       - Only one element, so child is a node with value 0.
# ⁠       - Empty array, so no child.
# 
# 
# Example 2:
# 
# 
# Input: nums = [3,2,1]
# Output: [3,null,2,null,1]
# 
# 
# 
# Constraints:
# 
# 
# 1 <= nums.length <= 1000
# 0 <= nums[i] <= 1000
# All integers in nums are unique.
# 
# 
#

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        return self.constructMaximumBinaryTreeRecrusily(nums, 0, len(nums) - 1)

    def constructMaximumBinaryTreeRecrusily(self, nums: List[int], left: int, right: int) -> Optional[TreeNode]:
        if left > right:
            return None
        n = right - left + 1
        if n == 0:
            return None
        if n == 1:
            return TreeNode(nums[left])
        max_index = self.findMaximumInNums(nums, left, right)
        root = TreeNode(nums[max_index])
        root.left = self.constructMaximumBinaryTreeRecrusily(nums, left, max_index - 1)
        root.right = self.constructMaximumBinaryTreeRecrusily(nums, max_index + 1, right)
        return root
    
    def findMaximumInNums(self, nums: List[int], left: int, right: int) -> int:
        max_index = left
        for i in range(left, right + 1):
            if nums[i] > nums[max_index]:
                max_index = i
        return max_index
# @lc code=end

