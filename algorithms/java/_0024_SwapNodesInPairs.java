/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (71.29%)
 * Likes:    1840
 * Dislikes: 0
 * Total Accepted:    637.3K
 * Total Submissions: 894K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * 
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class _0024_SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
// @lc code=start
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // 如果只有single结点或null结点
            if(head == null || head.next == null){
                return head;
            }
            ListNode dummyNode = new ListNode(-1, head);
            ListNode h = dummyNode;
            ListNode cur = head;
            while(cur != null && cur.next != null){
                ListNode first = cur, second = cur.next;
                ListNode next = cur.next.next;
                h.next = second;
                second.next = first;
                first.next = next;
                cur = next;
                h = first;
            }
            return dummyNode.next;
        }
    }
// @lc code=end

    @Test
    public void testSwapPairs() {
        // Test case 1: Swap pairs in a list with even number of elements
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        Solution sol = new Solution();
        ListNode result1 = sol.swapPairs(head1);
        assertEquals(2, result1.val);
        assertEquals(1, result1.next.val);
        assertEquals(4, result1.next.next.val);
        assertEquals(3, result1.next.next.next.val);
        assertNull(result1.next.next.next.next);
        
        // Test case 2: Swap pairs in a list with odd number of elements
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result2 = sol.swapPairs(head2);
        assertEquals(2, result2.val);
        assertEquals(1, result2.next.val);
        assertEquals(4, result2.next.next.val);
        assertEquals(3, result2.next.next.next.val);
        assertEquals(5, result2.next.next.next.next.val);
        assertNull(result2.next.next.next.next.next);
        
        // Test case 3: Swap pairs in a list with only one element
        ListNode head3 = new ListNode(1, null);
        ListNode result3 = sol.swapPairs(head3);
        assertEquals(1, result3.val);
        assertNull(result3.next);
        
        // Test case 4: Swap pairs in an empty list
        ListNode head4 = null;
        ListNode result4 = sol.swapPairs(head4);
        assertNull(result4);
    }

}

