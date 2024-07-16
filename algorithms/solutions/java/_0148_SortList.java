 /*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.cn/problems/sort-list/description/
 *
 * algorithms
 * Medium (65.57%)
 * Likes:    2292
 * Dislikes: 0
 * Total Accepted:    504.3K
 * Total Submissions: 769.1K
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

public class _0148_SortList {
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
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode mid = getMidListNode(head);
            ListNode next = mid.next;
            mid.next = null;
            ListNode leftHalf = sortList(head);
            ListNode rightHalf = sortList(next);
            return combine(leftHalf, rightHalf);
        }

        private ListNode combine(ListNode l1, ListNode l2){
            if(l1 == null && l2 == null) return null;
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            if(l1.val <= l2.val){
                l1.next = combine(l1.next, l2);
                return l1;
            }else{
                l2.next = combine(l1, l2.next);
                return l2;
            }
        }

        private ListNode getMidListNode(ListNode head){
            ListNode slow = head, fast = head;
            // 需要前点
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
// @lc code=end
}

