/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (54.87%)
 * Likes:    1255
 * Dislikes: 0
 * Total Accepted:    564.3K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [], val = 1
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 10^4].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * 
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class _0203_RemoveLinkedListElements {
    // Definition for singly-linked list.
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
// @lc code=start
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pre = new ListNode(-1, head);
            ListNode res = pre;
            if(head == null){
                return pre.next;
            }
            ListNode cur = head;
            while(cur != null){
                if(cur.val == val){
                    pre.next = cur.next;
                }else{
                    pre = pre.next;
                }
                cur = cur.next;
            }
            return res.next;
        }
    }
// @lc code=end
    @Test
    public void testRemoveElements() {
        // Test case 1: Remove a single element from the list
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        Solution sol = new Solution();
        ListNode result1 = sol.removeElements(head1, 2);
        assertEquals(1, result1.val);
        assertEquals(3, result1.next.val);
        assertNull(result1.next.next);
        
        // Test case 2: Remove multiple elements from the list
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, null))));
        ListNode result2 = sol.removeElements(head2, 2);
        assertEquals(1, result2.val);
        assertEquals(3, result2.next.val);
        assertNull(result2.next.next);
        
        // Test case 3: Remove all elements from the list
        ListNode head3 = new ListNode(2, new ListNode(2, new ListNode(2, null)));
        ListNode result3 = sol.removeElements(head3, 2);
        assertNull(result3);
        
        // Test case 4: Remove no elements from the list
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result4 = sol.removeElements(head4, 4);
        assertEquals(1, result4.val);
        assertEquals(2, result4.next.val);
        assertEquals(3, result4.next.next.val);
        assertNull(result4.next.next.next);
        
        // Test case 5: Remove elements from an empty list
        ListNode head5 = null;
        ListNode result5 = sol.removeElements(head5, 1);
        assertNull(result5);
    }
}

