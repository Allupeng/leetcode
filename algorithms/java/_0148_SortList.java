/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.cn/problems/sort-list/description/
 *
 * algorithms
 * Medium (65.57%)
 * Likes:    2155
 * Dislikes: 0
 * Total Accepted:    445K
 * Total Submissions: 679.1K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
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
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory
 * (i.e. constant space)?
 * 
 */

import org.junit.Test;

public class _0148_SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // @lc code=start
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode mid = getMid(head);
            ListNode left = head;
            ListNode right = mid.next;
            mid.next = null;

            left = sortList(left);
            right = sortList(right);

            return conquer(left, right);
        }

        private ListNode conquer(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return dummy.next;
        }

        private ListNode getMid(ListNode head){
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
// @lc code=end

    @Test
    public void test(){
        //[-1,5,3,4,0]
        Solution solution = new Solution();
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        solution.sortList(head);
    }

    private void print(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

