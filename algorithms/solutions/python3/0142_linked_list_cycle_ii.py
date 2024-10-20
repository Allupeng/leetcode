#
# @lc app=leetcode.cn id=142 lang=python3
#
# [142] Linked List Cycle II
#
# https://leetcode.cn/problems/linked-list-cycle-ii/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return None
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if slow == fast:
                fast = head
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        return None
        
# @lc code=end

