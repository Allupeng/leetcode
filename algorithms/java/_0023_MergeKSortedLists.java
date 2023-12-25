/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (58.31%)
 * Likes:    2604
 * Dislikes: 0
 * Total Accepted:    696.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted
 * in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: lists = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 * 
 * 
 */

import org.junit.Test;

import java.util.List;

public class _0023_MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

// @lc code=start
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0){
                return null;
            }
            return sort(lists, 0, lists.length - 1);
        }

        private ListNode sort(ListNode[] lists, int left, int right){
            int len = right - left + 1;
            if (len == 0) return null;
            if (len == 1) return lists[left];
            int mid = left + (right - left) / 2;
            ListNode leftNode = sort(lists, left, mid);
            ListNode rightNode = sort(lists, mid + 1, right);
            return conquer(leftNode, rightNode);
        }

        private ListNode conquer(ListNode l1, ListNode l2){
            if (l1 == null && l2 == null) return null;
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return dummy.next;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};
        solution.mergeKLists(listNodes);
    }
}

