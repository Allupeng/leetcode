/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (76.27%)
 * Likes:    1050
 * Dislikes: 0
 * Total Accepted:    634.6K
 * Total Submissions: 832K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the postorder traversal of its
 * nodes' values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _0145_BinaryTreePostorderTraversal {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            // 迭代法实现二叉树后序遍历
            // 前序遍历 中左右 -> 入栈顺序 中右左 -> 后续遍历 右左中 -> 入栈顺序 中左右 -> list反转
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode cur = stack.pop();
                result.add(cur.val);
                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
            Collections.reverse(result);
            return result;
        }

        // 递归法实现二叉树后序遍历
        private void postorderTreeTraversalRecursive(List<Integer> result, TreeNode node){
            if(node == null){
                return;
            }
            postorderTreeTraversalRecursive(result, node.left);
            postorderTreeTraversalRecursive(result, node.right);
            result.add(node.val);
        }
    }
// @lc code=end
}

