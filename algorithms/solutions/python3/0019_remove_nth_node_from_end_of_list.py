#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] Remove Nth Node From End of List
#
# https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        pre = dummy
        fast = head
        for i in range(n):
            fast = fast.next
        while fast:
            fast = fast.next
            pre = pre.next
        pre.next = pre.next.next
        return dummy.next
        
        
# @lc code=end

