/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (37.01%)
 * Likes:    2065
 * Dislikes: 0
 * Total Accepted:    734.1K
 * Total Submissions: 2M
 * Testcase Example:  '[2,1,3]'
 *
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is
 * 4.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 */


public class _0098_ValidateBinarySearchTree {
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
        Integer pre;
        public boolean isValidBST(TreeNode root) {
            // BST定义 左子树的所有值都要小于根节点
            // 右子树的所有值都大于根节点
            // 左子树的最右下角的结点值要小于根节点
            // 右子树的最左下角的结点值要大于根节点
            if (root == null) {
                return true;
            }
            boolean left = isValidBST(root.left);
            if (pre != null && pre >= root.val){
                return false;
            }
            pre = root.val;
            boolean right = isValidBST(root.right);
            return left & right;
        }
    }
// @lc code=end
}

