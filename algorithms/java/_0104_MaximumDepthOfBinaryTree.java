/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (77.13%)
 * Likes:    1630
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,2]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
 */
public class _0104_MaximumDepthOfBinaryTree {
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
        public int maxDepth(TreeNode root) {
            return calMaxDepth(root);
        }

        private int calMaxDepth(TreeNode node){
            if (node == null){
                return 0;
            }
            return 1 + Math.max(calMaxDepth(node.left), calMaxDepth(node.right));
        }
    }
// @lc code=end
}

