/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (72.19%)
 * Likes:    2200
 * Dislikes: 0
 * Total Accepted:    839.2K
 * Total Submissions: 1.2M
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

public class _0024_SwapNodesInPairs {
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
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                ListNode first = cur;
                ListNode second = cur.next;
                ListNode next = second.next;
                pre.next = second;
                second.next = first;
                first.next = next;
                pre = first;
                cur = next;
            }
            return dummy.next;
        }
    }
// @lc code=end
}

