/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (53.15%)
 * Likes:    1052
 * Dislikes: 0
 * Total Accepted:    615.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,1,2]'
 *
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * 
 * 
 */

public class _0083_RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
// @lc code=start
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(-1, head);
            ListNode cur = head.next, pre = head;
            while (cur != null){
                if (cur.val == pre.val){
                    pre.next = cur.next;
                    cur = cur.next;
                }else {
                    cur = cur.next;
                    pre = pre.next;
                }
            }
            return dummy.next;
        }
    }
// @lc code=end
}

