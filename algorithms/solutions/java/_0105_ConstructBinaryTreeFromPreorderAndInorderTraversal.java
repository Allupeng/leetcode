/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.57%)
 * Likes:    2284
 * Dislikes: 0
 * Total Accepted:    640.1K
 * Total Submissions: 894.3K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * 
 * 
 */

public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
        private int preIndex = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildHelper(preorder, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildHelper(int[] preorder, int[] inorder, int left, int right){
            if (left > right) return null;
            int rootValue = preorder[preIndex];
            preIndex++;
            int rootIndexForInorder = findInorderIndexByValue(rootValue, inorder, left, right);
            TreeNode root = new TreeNode(rootValue);
            root.left = buildHelper(preorder, inorder, left, rootIndexForInorder - 1);
            root.right = buildHelper(preorder, inorder, rootIndexForInorder + 1, right);
            return root;
        }

        private int findInorderIndexByValue(int value, int[] inorder, int start, int end){
            if (start > end) return -1;
            for(int i = start; i <= end; i++){
                if (inorder[i] == value){
                    return i;
                }
            }
            return -1;
        }
    }
// @lc code=end
}

