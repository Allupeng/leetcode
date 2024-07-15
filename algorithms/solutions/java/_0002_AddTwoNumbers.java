package hot100;/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.cn/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (43.57%)
 * Likes:    10550
 * Dislikes: 0
 * Total Accepted:    2.1M
 * Total Submissions: 4.7M
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


public class _0002_AddTwoNumbers {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {return null;}
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int carry = 0, value = 0;
            while (l1 != null || l2 != null) {
                int value1 = (l1 != null) ? l1.val : 0;
                int value2 = (l2 != null) ? l2.val : 0;
                value = (value1 + value2 + carry) % 10;
                carry = (value1 + value2 + carry) / 10;
                ListNode node = new ListNode(value);
                cur.next = node;
                cur = node;
                if(l1 != null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            if(carry != 0){
                cur.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
// @lc code=end

}

