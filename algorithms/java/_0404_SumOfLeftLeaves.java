/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * https://leetcode.cn/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (62.38%)
 * Likes:    617
 * Dislikes: 0
 * Total Accepted:    241.7K
 * Total Submissions: 387.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 * 
 * A leaf is a node with no children. A left leaf is a leaf that is the left
 * child of another node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and
 * 15 respectively.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 * 
 * 
 */

public class _0404_SumOfLeftLeaves {
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
        public int sumOfLeftLeaves(TreeNode root) {
            // must use parent node to define left leaf node
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null) return 0;
            int leftValue = sumOfLeftLeaves(root.left);
            if (root.left != null && root.left.left == null && root.left.right == null){
                leftValue = root.left.val;
            }
            int rightValue = sumOfLeftLeaves(root.right);
            return leftValue + rightValue;
        }

    }
// @lc code=end
}

