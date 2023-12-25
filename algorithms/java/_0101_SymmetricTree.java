/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (58.81%)
 * Likes:    2452
 * Dislikes: 0
 * Total Accepted:    845.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Could you solve it both recursively and iteratively?
 */

import java.util.LinkedList;
import java.util.Queue;

public class _0101_SymmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            // iteratively
            if (root == null){
                return true;
            }
            // 用队列存储结点的顺序然后进行比较
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left == null && right == null){
                    continue;
                }
                if (left == null || right == null || (left.val != right.val)){
                    return false;
                }
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
        }

        // recursively
        private boolean isSymmetricRecursively(TreeNode left, TreeNode right){
            if (left == null && right == null){
                return true;
            }
            if (left == null || right == null){
                return false;
            }
            return left.val == right.val && isSymmetricRecursively(left.right , right.left) && isSymmetricRecursively(left.left, right.right);
        }
    }
// @lc code=end
}

