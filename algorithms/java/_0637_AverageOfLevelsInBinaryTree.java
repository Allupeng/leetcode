/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (69.80%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    142.1K
 * Total Submissions: 203.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the average value of the nodes on
 * each level in the form of an array. Answers within 10^-5 of the actual
 * answer will be accepted.
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0637_AverageOfLevelsInBinaryTree {
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
        public List<Double> averageOfLevels(TreeNode root) {
            //层序遍历，在每层遍历的时候求平均值
            List<Double> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                double sum = 0;
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if (cur == null){
                        continue;
                    }
                    sum += cur.val;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(sum / size);
            }
            return result;
        }
    }
// @lc code=end
}

