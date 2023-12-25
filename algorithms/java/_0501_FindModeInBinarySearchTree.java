/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (54.65%)
 * Likes:    652
 * Dislikes: 0
 * Total Accepted:    162.4K
 * Total Submissions: 297.1K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given the root of a binary search tree (BST) with duplicates, return all the
 * mode(s) (i.e., the most frequently occurred element) in it.
 * 
 * If the tree has more than one mode, return them in any order.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,2]
 * Output: [2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 */

import java.util.ArrayList;
import java.util.List;

public class _0501_FindModeInBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
// @lc code=start
    class Solution {
        private TreeNode pre;
        private int count;
        private int maxValue;
        public int[] findMode(TreeNode root) {
            count = 0;
            maxValue = 0;
            List<Integer> result = new ArrayList<>();
            findModeHelper(root, result);
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        private void findModeHelper(TreeNode cur, List<Integer> result){
            if (cur == null){
                return;
            }
            findModeHelper(cur.left, result);
            if (pre == null || pre.val != cur.val){
                count = 1;
            }else {
                count++;
            }
            if (count == maxValue) {
                result.add(cur.val);
            }else if (count > maxValue){
                result.clear();
                result.add(cur.val);
                maxValue = count;
            }
            pre = cur;
            findModeHelper(cur.right, result);
        }
    }
// @lc code=end
}

