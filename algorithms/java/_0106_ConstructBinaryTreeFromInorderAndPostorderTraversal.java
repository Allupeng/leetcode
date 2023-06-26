/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (72.11%)
 * Likes:    1039
 * Dislikes: 0
 * Total Accepted:    288.4K
 * Total Submissions: 399.9K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 * 
 * 
 */

public class _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
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
        private int postOrderRootIndex;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // postorder的最后一个元素永远是根元素
            postOrderRootIndex = postorder.length - 1;
            return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
        }

        private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd){
            if (inorderStart > inorderEnd){
                return null;
            }
            TreeNode root = new TreeNode(postorder[postOrderRootIndex]);
            postOrderRootIndex--;

            int rootIndex = findRootIndexInInorderArray(inorder, inorderStart, inorderEnd, root.val);
            // root.right 要写在前面的原因是因为postOrderRootIndex--只在右子树遍历时才 always处于postorder的最后一位
            root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inorderEnd);
            root.left = buildTreeHelper(inorder, postorder, inorderStart, rootIndex - 1);
            return root;
        }

        private int findRootIndexInInorderArray(int[] inorder,int start, int end, int value){
            for (int i = start; i <= end; i++){
                if (inorder[i] == value){
                    return i;
                }
            }
            return -1; // invalid value
        }
    }
// @lc code=end
}

