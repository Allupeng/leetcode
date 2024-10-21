#
# @lc app=leetcode.cn id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#
# https://leetcode.cn/problems/swap-nodes-in-pairs/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        dummy = ListNode(-1, head)
        pre = dummy
        cur = head
        while cur and cur.next:
            first, second, secondNext = cur, cur.next, cur.next.next
            first.next = secondNext
            second.next = first
            pre.next = second
            cur = secondNext
            pre = first
            
        return dummy.next
        
# @lc code=end

