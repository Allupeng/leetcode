package hot100;/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (59.47%)
 * Likes:    2809
 * Dislikes: 0
 * Total Accepted:    798.7K
 * Total Submissions: 1.3M
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


public class _0023_MergeKSortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKListsCore(lists, 0, lists.length - 1);
        }

        private ListNode mergeKListsCore(ListNode[] lists, int left, int right){
            int len = right - left + 1;
            if(len == 0) return null;
            if(len == 1) return lists[left];
            int mid = left + ((right - left) >> 1);
            ListNode leftHalf = mergeKListsCore(lists, left, mid);
            ListNode rightHalf = mergeKListsCore(lists, mid + 1, right);
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
    }
// @lc code=end

}
