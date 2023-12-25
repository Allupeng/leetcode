/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.28%)
 * Likes:    1996
 * Dislikes: 0
 * Total Accepted:    503.9K
 * Total Submissions: 706.9K
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
        private int preOrderIndex;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 前序最左边的是根节点
            preOrderIndex = 0;
            return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd){
            if (inorderStart > inorderEnd){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preOrderIndex]);
            preOrderIndex++;
            int inOrderIndex = findRootIndexInInorder(inorder, inorderStart, inorderEnd, root.val);
            root.left = buildTreeHelper(preorder, inorder, inorderStart, inOrderIndex - 1);
            root.right = buildTreeHelper(preorder, inorder, inOrderIndex + 1, inorderEnd);
            return root;
        }

        private int findRootIndexInInorder(int[] inorder, int start, int end, int value){
            for (int i = start; i <= end; i++){
                if (inorder[i] == value){
                    return i;
                }
            }
            return -1;
        }
    }
// @lc code=end
}

