package hot100;

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
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int value = 0, carry = 0;
            while (l1 != null || l2 != null) {
                int v1 = l1 != null ? l1.val : 0;
                int v2 = l2 != null ? l2.val : 0;
                value = (v1 + v2 + carry) % 10;
                carry = (v1 + v2 + carry) / 10;
                ListNode node = new ListNode(value);
                cur.next = node;
                cur = node;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry != 0) {
                cur.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
// @lc code=end

}
