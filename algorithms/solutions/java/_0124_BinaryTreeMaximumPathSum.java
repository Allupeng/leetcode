/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (45.50%)
 * Likes:    2213
 * Dislikes: 0
 * Total Accepted:    405.6K
 * Total Submissions: 891.4K
 * Testcase Example:  '[1,2,3]'
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent
 * nodes in the sequence has an edge connecting them. A node can only appear in
 * the sequence at most once. Note that the path does not need to pass through
 * the root.
 * 
 * The path sum of a path is the sum of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any
 * non-empty path.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 =
 * 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 +
 * 7 = 42.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 3 * 10^4].
 * -1000 <= Node.val <= 1000
 * 
 * 
 */

public class _0124_BinaryTreeMaximumPathSum {
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
        private int maxResult = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            maxGain(root);
            return maxResult;
        }

        private int maxGain(TreeNode cur){
            if (cur == null) return 0;
            int leftMaxGain = Math.max(0, maxGain(cur.left));
            int rightMaxGain = Math.max(0, maxGain(cur.right));
            int curSum = leftMaxGain + cur.val + rightMaxGain;
            maxResult = Math.max(maxResult, curSum);
            return cur.val + Math.max(leftMaxGain, rightMaxGain);
        }
    }
// @lc code=end
}

