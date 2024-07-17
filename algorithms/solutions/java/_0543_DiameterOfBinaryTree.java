/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (60.21%)
 * Likes:    1525
 * Dislikes: 0
 * Total Accepted:    418.1K
 * Total Submissions: 694.4K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
 */

public class _0543_DiameterOfBinaryTree {
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
        private int diameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            maxDiameter(root);
            return diameter;
        }

        private int maxDiameter(TreeNode cur){
            if (cur == null) return 0;
            int leftMaxDiameter = maxDiameter(cur.left);
            int rightMaxDiameter = maxDiameter(cur.right);
            diameter = Math.max(diameter, leftMaxDiameter + rightMaxDiameter);
            return Math.max(leftMaxDiameter, rightMaxDiameter) + 1;
        }
    }
// @lc code=end
}

