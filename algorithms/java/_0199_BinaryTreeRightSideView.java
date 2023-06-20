/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (65.86%)
 * Likes:    886
 * Dislikes: 0
 * Total Accepted:    292.1K
 * Total Submissions: 443.5K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to
 * bottom.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,null,3]
 * Output: [1,3]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0199_BinaryTreeRightSideView {

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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            List<List<Integer>> levelResult = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> tmpResult = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if (cur == null){
                        continue;
                    }
                    tmpResult.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                levelResult.add(tmpResult);
            }
            // 将每个list的最后一个拿出来
            for (List<Integer> list : levelResult){
                result.add(list.get(list.size() - 1));
            }
            return result;
        }
    }
// @lc code=end
    @Test
    public void test(){
        TreeNode root = new TreeNode(1
                , new TreeNode(2, null, new TreeNode(5))
                , new TreeNode(3, null, new TreeNode(4)));
        Solution solution = new Solution();
        solution.rightSideView(root);
    }
}

