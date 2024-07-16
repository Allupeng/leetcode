/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (76.74%)
 * Likes:    2073
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _0094_BinaryTreeInorderTraversal {
      static class TreeNode {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                while(cur != null){
                    stack.offerFirst(cur);
                    cur = cur.left;
                }
                cur = stack.pollFirst();
                result.add(cur.val);
                cur = cur.right;
            }
            return result;
        }
    }
// @lc code=end
}

