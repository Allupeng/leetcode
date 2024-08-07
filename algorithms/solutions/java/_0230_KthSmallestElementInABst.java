/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 *
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (77.13%)
 * Likes:    845
 * Dislikes: 0
 * Total Accepted:    357.8K
 * Total Submissions: 463.9K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * Given the root of a binary search tree, and an integer k, return the k^th
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 * 
 * 
 * 
 * Follow up: If the BST is modified often (i.e., we can do insert and delete
 * operations) and you need to find the kth smallest frequently, how would you
 * optimize?
 * 
 */

public class _0230_KthSmallestElementInABst {
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
        private int cnt = 0;
        private int result = 0;

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return result;
        }

        private void dfs(TreeNode cur, int k){
            if (cur == null) return;
            dfs(cur.left, k);
            cnt++;
            if (cnt == k){
                result = cur.val;
                return;
            }
            dfs(cur.right, k);
        }
    }
// @lc code=end
}

