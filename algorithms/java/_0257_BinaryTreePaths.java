/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.cn/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (70.69%)
 * Likes:    971
 * Dislikes: 0
 * Total Accepted:    318.2K
 * Total Submissions: 450.2K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any
 * order.
 * 
 * A leaf is a node with no children.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: ["1"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 */



import java.util.ArrayList;
import java.util.List;

public class _0257_BinaryTreePaths {
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> result){
        paths.add(node.val);
        if (node.left == null && node.right == null){
            // if reach leaf node , store the paths to result
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++){
                str.append(paths.get(i)).append("->");
            }
            str.append(paths.get(paths.size() - 1));
            result.add(str.toString());
            return;
        }
        if (node.left != null){
            traversal(node.left, paths, result);
            paths.remove(paths.size() - 1);
        }
        if (node.right != null){
            traversal(node.right, paths, result);
            paths.remove(paths.size() - 1);
        }
    }
}
// @lc code=end
}

