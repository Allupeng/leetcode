package hot100;/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (67.89%)
 * Likes:    2317
 * Dislikes: 0
 * Total Accepted:    592.6K
 * Total Submissions: 872.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time,
 * and return the modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes, in the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 */

public class _0025_ReverseNodesInKGroup {
    // Definition for singly-linked list.
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
        public ListNode reverseKGroup(ListNode head, int k) {
            int cnt = 0;
            ListNode last = head;
            while (cnt != k) {
                if (last == null) {
                    return head;
                }
                last = last.next;
                cnt++;
            }
            ListNode newHead = reverseList(head, last);
            head.next = reverseKGroup(last, k);
            return newHead;
        }

        private ListNode reverseList(ListNode start, ListNode last){
            ListNode pre = null;
            ListNode cur = start;
            while (cur != last) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
// @lc code=end
}

