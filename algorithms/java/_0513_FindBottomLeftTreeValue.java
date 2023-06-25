/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.cn/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (73.55%)
 * Likes:    493
 * Dislikes: 0
 * Total Accepted:    191.2K
 * Total Submissions: 260K
 * Testcase Example:  '[2,1,3]'
 *
 * Given the root of a binary tree, return the leftmost value in the last row
 * of the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,3,4,null,5,6,null,null,7]
 * Output: 7
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

public class _0513_FindBottomLeftTreeValue {
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
        public int findBottomLeftValue(TreeNode root) {
            //层序遍历，返回最后一个list的第一个元素
            if (root == null) return 0;
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if (cur == null){
                        continue;
                    }
                    list.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                result.add(list);
            }
            return result.get(result.size() - 1).get(0);
        }
    }
// @lc code=end
}

