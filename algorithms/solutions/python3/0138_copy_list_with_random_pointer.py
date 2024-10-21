#
# @lc app=leetcode.cn id=138 lang=python3
#
# [138] Copy List with Random Pointer
#
# https://leetcode.cn/problems/copy-list-with-random-pointer/description/
#

# @lc code=start
"""
# Definition for a Node.
"""
from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        m = {}
        cur = head
        while cur:
            node = Node(cur.val)
            m[cur] = node
            cur = cur.next
        cur = head
        while cur:
            node = m[cur]
            node.next = m[cur.next] if cur.next else None
            node.random = m[cur.random] if cur.random else None
            cur = cur.next
        return m[head]
# @lc code=end

