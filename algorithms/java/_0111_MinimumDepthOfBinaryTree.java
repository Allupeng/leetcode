/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (52.17%)
 * Likes:    1024
 * Dislikes: 0
 * Total Accepted:    565K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^5].
 * -1000 <= Node.val <= 1000
 * 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class _0111_MinimumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
// @lc code=start
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                depth++;
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if (cur == null){
                        continue;
                    }
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    if (cur.left == null && cur.right == null){
                        return depth;
                    }
                }
            }
            return depth;
        }
    }
// @lc code=end
}

