#
# @lc app=leetcode.cn id=160 lang=python3
#
# [160] Intersection of Two Linked Lists
#
# https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
#

# @lc code=start
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        a , b = headA, headB
        while a != b:
            a = a.next if a else headB
            b = b.next if b else headA
        return a
        
# @lc code=end

