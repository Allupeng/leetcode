#
# @lc app=leetcode.cn id=2 lang=python3
#
# [2] Add Two Numbers
#
# https://leetcode.cn/problems/add-two-numbers/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        cur = dummy
        value = carry = 0
        while l1 or l2:
            v1 = 0 if not l1 else l1.val
            v2 = 0 if not l2 else l2.val
            value = (v1 + v2 + carry) % 10
            carry = (v1 + v2 + carry) // 10
            node = ListNode(value)
            cur.next = node
            cur = node
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        if carry != 0:
            cur.next = ListNode(carry)
        return dummy.next
# @lc code=end

