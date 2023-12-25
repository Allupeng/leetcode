/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (53.60%)
 * Likes:    1795
 * Dislikes: 0
 * Total Accepted:    641K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,2,1]'
 *
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

public class _0234_PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // @lc code=start
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 先利用快慢指针找到中点
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode secondHalf = reverse(slow.next);
            ListNode p1 = head;
            ListNode p2 = secondHalf;
            while(p2 != null){
                if (p1.val != p2.val){
                    return false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        // 反转链表
        private ListNode reverse(ListNode head){
            ListNode cur = head;
            ListNode prev = null;
            while (cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
// @lc code=end
}

