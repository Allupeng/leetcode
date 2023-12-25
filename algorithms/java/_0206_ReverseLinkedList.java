/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (73.50%)
 * Likes:    3174
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 2M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * 
 * 
 * Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 */

public class _0206_ReverseLinkedList {
      static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

// @lc code=start
    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverseListRecursive(head);
        }

        // 递归法翻转链表
        private ListNode reverseListRecursive(ListNode head){
            return reverseListRecursiveSingle(null, head);
        }

        private ListNode reverseListRecursiveSingle(ListNode pre, ListNode cur){
            if (cur == null){
                return pre;
            }
            ListNode next = cur.next;
            cur.next = pre;
            return reverseListRecursiveSingle(cur, next);
        }

        // 迭代法翻转链表
        private ListNode reverseListIterative(ListNode head) {
            if (head == null){
                return null;
            }
            if(head.next == null){
                return head;
            }
            ListNode pre = null;
            while(head != null){
                ListNode cur = head;
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                head = next;
            }
            return pre;
        }
    }
// @lc code=end
}

