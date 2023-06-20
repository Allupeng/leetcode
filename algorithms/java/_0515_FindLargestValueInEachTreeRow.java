/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (66.41%)
 * Likes:    322
 * Dislikes: 0
 * Total Accepted:    122.2K
 * Total Submissions: 183.9K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * Given the root of a binary tree, return an array of the largest value in
 * each row of the tree (0-indexed).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3]
 * Output: [1,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree will be in the range [0, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0515_FindLargestValueInEachTreeRow {
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                int max = queue.peek().val;
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if (cur == null){
                        continue;
                    }
                    max = Math.max(max, cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(max);
            }
            return result;
        }
    }
// @lc code=end
}

