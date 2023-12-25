

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.cn/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (80.96%)
 * Likes:    962
 * Dislikes: 0
 * Total Accepted:    292.9K
 * Total Submissions: 361.8K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given the root of a complete binary tree, return the number of the nodes in
 * the tree.
 * 
 * According to Wikipedia, every level, except possibly the last, is completely
 * filled in a complete binary tree, and all nodes in the last level are as far
 * left as possible. It can have between 1 and 2^h nodes inclusive at the last
 * level h.
 * 
 * Design an algorithm that runs in less than O(n) time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 5 * 10^4].
 * 0 <= Node.val <= 5 * 10^4
 * The tree is guaranteed to be complete.
 * 
 * 
 */
public class _0222_CountCompleteTreeNodes {
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
        public int countNodes(TreeNode root) {
            if (root == null){
                return 0;
            }
            int leftHeight = 1, rightHeight = 1;
            TreeNode left = root.left;
            TreeNode right = root.right;
            while (left != null){
                leftHeight++;
                left = left.left;
            }
            while (right != null){
                rightHeight++;
                right = right.right;
            }
            if (rightHeight == leftHeight){
                return (int)Math.pow(2, rightHeight) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
// @lc code=end
}

