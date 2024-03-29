/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] House Robber III
 *
 * https://leetcode.cn/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (61.13%)
 * Likes:    1735
 * Dislikes: 0
 * Total Accepted:    285.1K
 * Total Submissions: 466.4K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called root.
 * 
 * Besides the root, each house has one and only one parent house. After a
 * tour, the smart thief realized that all houses in this place form a binary
 * tree. It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 * 
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * 0 <= Node.val <= 10^4
 * 
 * 
 */

public class _0337_HouseRobberIii {
// @lc code=start
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

    class Solution {
        public int rob(TreeNode root) {
            if (root == null){
                return 0;
            }
            int[] dp = DPRecursive(root);
            return Math.max(dp[0], dp[1]);
        }

        private int[] DPRecursive(TreeNode root){
            // dp[0]代表不偷该节点，dp[1]代表偷该节点
            if (root == null){
                return new int[]{0, 0};
            }
            int[] dp = new int[2];
            int[] left = DPRecursive(root.left);
            int[] right = DPRecursive(root.right);
            dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            dp[1] = root.val + left[0] + right[0];
            return dp;
        }
    }
// @lc code=end
}

