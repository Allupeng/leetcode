/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.cn/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (42.64%)
 * Likes:    9881
 * Dislikes: 0
 * Total Accepted:    1.8M
 * Total Submissions: 4.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 * 
 * 
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0002_AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
// @lc code=start
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null){
                return null;
            }
            if (l1 == null){
                return l2;
            }
            if (l2 == null){
                return l1;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int value;
            int carry = 0;
            while (l1 != null || l2 != null){
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                value = (val1 + val2 + carry) % 10;
                carry = (val1 + val2 + carry) / 10;
                ListNode node = new ListNode(value);
                cur.next = node;
                cur = node;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry != 0){
                cur.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
// @lc code=end
    @Test
    public void testAddTwoNumbers() {
        // Test case 1: Valid input
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode expected1 = new ListNode(7, new ListNode(0, new ListNode(8)));
        ListNode result1 = new Solution().addTwoNumbers(l1, l2);
        assertLinkedListNode(expected1, result1);

        // Test case 2: Different length inputs
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l4 = new ListNode(1);
        ListNode expected2 = new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))));
        ListNode result2 = new Solution().addTwoNumbers(l3, l4);
        assertLinkedListNode(expected2, result2);

        // Test case 3: One input is null
        ListNode l5 = null;
        ListNode l6 = new ListNode(1);
        ListNode expected3 = new ListNode(1);
        ListNode result3 = new Solution().addTwoNumbers(l5, l6);
        assertLinkedListNode(expected3, result3);

        // Test case 4: Both inputs are null
        ListNode l7 = null;
        ListNode l8 = null;
        ListNode expected4 = null;
        ListNode result4 = new Solution().addTwoNumbers(l7, l8);
        assertLinkedListNode(expected4, result4);
    }

    private void assertLinkedListNode(ListNode expected, ListNode result){
        while(expected != null || result != null){
            int expectedValue = expected == null ? -1 : expected.val;
            int resultValue = result == null ? -1 : result.val;
            assertEquals(expectedValue, resultValue);
            if (expected != null) expected = expected.next;
            if (result != null) result = result.next;
        }
    }
}

