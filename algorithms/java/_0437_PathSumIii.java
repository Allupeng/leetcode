/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.cn/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (49.14%)
 * Likes:    1747
 * Dislikes: 0
 * Total Accepted:    255.1K
 * Total Submissions: 519.4K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * Given the root of a binary tree and an integer targetSum, return the number
 * of paths where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 1000].
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
 * 
 * 
 */

public class _0437_PathSumIii {
// @lc code=start
    public class TreeNode {
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
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null){
                return 0;
            }
            int cnt = 0;
            cnt += pathSumFromNode(root, targetSum);
            cnt += pathSum(root.left, targetSum);
            cnt += pathSum(root.right, targetSum);
            return cnt;
        }

        private int pathSumFromNode(TreeNode node, long targetSum){
            if (node == null){
                return 0;
            }
            int cnt = 0;
            if (node.val == targetSum){
                cnt++;
            }
            cnt += pathSumFromNode(node.left, targetSum - node.val);
            cnt += pathSumFromNode(node.right, targetSum - node.val);
            return cnt;
        }
    }
// @lc code=end
}

