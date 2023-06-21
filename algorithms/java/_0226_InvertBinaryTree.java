/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] Invert Binary Tree
 *
 * https://leetcode.cn/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (79.53%)
 * Likes:    1616
 * Dislikes: 0
 * Total Accepted:    681.4K
 * Total Submissions: 856.8K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: []
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
 */

public class _0226_InvertBinaryTree {
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return root;
            }
            swap(root);
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

        private void swap(TreeNode node){
            if(node == null){
                return;
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
// @lc code=end
}

