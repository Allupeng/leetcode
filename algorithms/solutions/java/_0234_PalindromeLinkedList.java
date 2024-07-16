 /*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (54.38%)
 * Likes:    1888
 * Dislikes: 0
 * Total Accepted:    734.2K
 * Total Submissions: 1.4M
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
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
// @lc code=start
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null) return true;
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            fast = head;
            slow = reverseList(slow);
            while (slow != null) {
                if (slow.val != fast.val) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }

        private ListNode reverseList(ListNode head){
            if(head == null || head.next == null) return head;
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }
// @lc code=end
}

