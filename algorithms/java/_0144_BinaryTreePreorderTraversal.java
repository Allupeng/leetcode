/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.26%)
 * Likes:    1080
 * Dislikes: 0
 * Total Accepted:    874.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
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
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0144_BinaryTreePreorderTraversal {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            // 迭代法实现前序遍历
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            // pop顺序是根、左、右
            // 所以push顺序为根、右、左
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
            return result;
        }

        // 递归法实现前序遍历
        private void preorderTreeTraversalRecursive(List<Integer> result, TreeNode node){
            if(node == null){
                return;
            }
            result.add(node.val);
            preorderTreeTraversalRecursive(result, node.left);
            preorderTreeTraversalRecursive(result, node.right);
        }
    }
// @lc code=end

}

