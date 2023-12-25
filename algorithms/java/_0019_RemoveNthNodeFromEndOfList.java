/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (45.58%)
 * Likes:    2557
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.5M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given the head of a linked list, remove the n^th node from the end of the
 * list and return its head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 * 
 * 
 * Follow up: Could you do this in one pass?
 * 
 */




public class _0019_RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
// @lc code=start
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null){
                return null;
            }
            // 假如整个链表长度为k
            // 倒数第n个结点 = 正数 n - k个结点
            // 所以删除倒数第n个结点就是找到正数 n - k个结点的pre结点
            ListNode dummyNode = new ListNode(-1, head);
            ListNode pre = dummyNode;
            ListNode cur = head;
            int k = 0;
            while(k < n){
                k++;
                cur = cur.next;
            }
            while(cur != null){
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = pre.next.next;
            return dummyNode.next;
        }
    }
// @lc code=end
}

