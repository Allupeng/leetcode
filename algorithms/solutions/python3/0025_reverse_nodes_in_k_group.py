#
# @lc app=leetcode.cn id=25 lang=python3
#
# [25] Reverse Nodes in k-Group
#
# https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        last = head
        cnt = 0
        while cnt < k:
            if not last:
                return head
            last = last.next
            cnt += 1
        newListNode = self.reverseListNode(head, last)
        head.next = self.reverseKGroup(last, k)
        return newListNode
        
        
    def reverseListNode(self, head: Optional[ListNode], last: Optional[ListNode]) -> Optional[ListNode]:
        pre = None
        while head != last:
            next = head.next
            head.next = pre
            pre = head
            head = next
        return pre
        
# @lc code=end

