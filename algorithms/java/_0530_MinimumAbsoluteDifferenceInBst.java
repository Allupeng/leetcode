/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (63.43%)
 * Likes:    472
 * Dislikes: 0
 * Total Accepted:    181.1K
 * Total Submissions: 285.6K
 * Testcase Example:  '[4,2,6,1,3]'
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute
 * difference between the values of any two different nodes in the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 10^4].
 * 0 <= Node.val <= 10^5
 * 
 * 
 * 
 * Note: This question is the same as 783:
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 
 */

public class _0530_MinimumAbsoluteDifferenceInBst {
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
        // 存储前一个结点
        private TreeNode pre;
        private int minValue = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            // BST tree 中序遍历是有序的
            calculateMinValue(root);
            return minValue;
        }

        private void calculateMinValue(TreeNode cur){
            if (cur == null){
                return;
            }
            calculateMinValue(cur.left);
            if (pre != null){
                minValue = Math.min(cur.val - pre.val, minValue);
            }

            pre = cur;
            calculateMinValue(cur.right);
        }
    }
// @lc code=end
}

