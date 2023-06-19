/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (76.21%)
 * Likes:    1842
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 1.5M
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
import java.util.List;
import java.util.Stack;

public class _0094_BinaryTreeInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            // 迭代法实现中序遍历
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()){
                // 当cur不为null,一直往左子树遍历
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                // 输出中间结点
                cur = stack.pop();
                result.add(cur.val);
                // 遍历右边结点
                cur = cur.right;
            }
            return result;
        }

        // 递归法实现中序遍历
        private void inorderTraversalRecursive(List<Integer> result, TreeNode node){
            if (node == null){
                return;
            }
            inorderTraversalRecursive(result, node.left);
            result.add(node.val);
            inorderTraversalRecursive(result, node.right);
        }

    }
// @lc code=end

}

