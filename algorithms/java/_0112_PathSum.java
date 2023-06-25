/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] Path Sum
 *
 * https://leetcode.cn/problems/path-sum/description/
 *
 * algorithms
 * Easy (53.53%)
 * Likes:    1200
 * Dislikes: 0
 * Total Accepted:    554.1K
 * Total Submissions: 1M
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * Given the root of a binary tree and an integer targetSum, return true if the
 * tree has a root-to-leaf path such that adding up all the values along the
 * path equals targetSum.
 * 
 * A leaf is a node with no children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * 
 * 
 */

public class _0112_PathSum {
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            // back trace to find a path which is sum equals targetSum
            if (root == null){
                return false;
            }
            return hasPathSumRecursively(root, root.val, targetSum);
        }

        private boolean hasPathSumRecursively(TreeNode node, int count, int targetSum){
            if (node.left == null && node.right == null && count == targetSum) return true;
            if (node.left == null && node.right == null) return false;
            if (node.left != null){
                count += node.left.val;
                if (hasPathSumRecursively(node.left, count, targetSum)) return true;
                count -= node.left.val;
            }
            if (node.right != null){
                count += node.right.val;
                if (hasPathSumRecursively(node.right, count, targetSum)) return true;
                count -= node.right.val;
            }
            return false;
        }
    }
// @lc code=end
}

