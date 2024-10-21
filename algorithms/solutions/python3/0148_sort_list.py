#
# @lc app=leetcode.cn id=148 lang=python3
#
# [148] Sort List
#
# https://leetcode.cn/problems/sort-list/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        mid = self.getMidNode(head)
        next = mid.next
        mid.next = None
        leftPart = self.sortList(head)
        rightPart = self.sortList(next)
        return self.mergeTwoListNodes(leftPart, rightPart)
    
    def mergeTwoListNodes(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l1 and not l2:
            return None
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val <= l2.val:
            l1.next = self.mergeTwoListNodes(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoListNodes(l1, l2.next)
            return l2
        
    
    def getMidNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow
        
# @lc code=end

