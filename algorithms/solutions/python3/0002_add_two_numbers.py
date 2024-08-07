#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] Add Two Numbers
#
# https://leetcode.cn/problems/add-two-numbers/description/
#
# algorithms
# Medium (43.91%)
# Likes:    10677
# Dislikes: 0
# Total Accepted:    2.1M
# Total Submissions: 4.8M
# Testcase Example:  '[2,4,3]\n[5,6,4]'
#
# You are given two non-empty linked lists representing two non-negative
# integers. The digits are stored in reverse order, and each of their nodes
# contains a single digit. Add the two numbers and return the sum as a linked
# list.
# 
# You may assume the two numbers do not contain any leading zero, except the
# number 0 itself.
# 
# 
# Example 1:
# 
# 
# Input: l1 = [2,4,3], l2 = [5,6,4]
# Output: [7,0,8]
# Explanation: 342 + 465 = 807.
# 
# 
# Example 2:
# 
# 
# Input: l1 = [0], l2 = [0]
# Output: [0]
# 
# 
# Example 3:
# 
# 
# Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
# Output: [8,9,9,9,0,0,0,1]
# 
# 
# 
# Constraints:
# 
# 
# The number of nodes in each linked list is in the range [1, 100].
# 0 <= Node.val <= 9
# It is guaranteed that the list represents a number that does not have leading
# zeros.
# 
# 
#

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# @lc code=start
from typing import Optional


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if l1 is None and l2 is None:
            return None
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        dummy = ListNode(-1)
        cur = dummy
        value, carry = 0, 0
        while l1 is not None or l2 is not None:
            value1 = l1.val if l1 else 0
            value2 = l2.val if l2 else 0
            value = (value1 + value2 + carry) % 10
            carry = (value1 + value2 + carry) // 10
            node = ListNode(value)
            cur.next = node
            cur = node
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        if carry != 0:
            cur.next = ListNode(carry)
        return dummy.next
        
        
# @lc code=end

