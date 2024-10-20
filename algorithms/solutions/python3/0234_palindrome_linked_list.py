#
# @lc app=leetcode.cn id=234 lang=python3
#
# [234] Palindrome Linked List
#
# https://leetcode.cn/problems/palindrome-linked-list/description/
#

# @lc code=start
# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        slow = self.reverseList(slow)
        fast = head
        while slow:
            if slow.val != fast.val:
                return False
            slow = slow.next
            fast = fast.next
        return True
    
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        last = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return last
        
# @lc code=end

