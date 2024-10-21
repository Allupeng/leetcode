#
# @lc app=leetcode.cn id=23 lang=python3
#
# [23] Merge k Sorted Lists
#
# https://leetcode.cn/problems/merge-k-sorted-lists/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        return self.mergeKListsCore(lists, 0, len(lists) - 1)
    
    def mergeKListsCore(self, lists: List[Optional[ListNode]], left: int, right: int) -> Optional[ListNode]:
        length = right - left + 1
        if length == 0:
            return None
        if length == 1:
            return lists[left]
        mid = left + ((right - left) >> 1)
        leftPart = self.mergeKListsCore(lists, left, mid)
        rightPart = self.mergeKListsCore(lists, mid + 1, right)
        return self.mergeTwoLists(leftPart, rightPart)
    
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l1 and not l2:
            return None
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
        
# @lc code=end

