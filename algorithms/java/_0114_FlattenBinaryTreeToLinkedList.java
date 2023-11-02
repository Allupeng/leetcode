/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (73.18%)
 * Likes:    1575
 * Dislikes: 0
 * Total Accepted:    398.1K
 * Total Submissions: 544K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given the root of a binary tree, flatten the tree into a "linked
 * list":
 * 
 * 
 * The "linked list" should use the same TreeNode class where the right child
 * pointer points to the next node in the list and the left child pointer is
 * always null.
 * The "linked list" should be in the same order as a pre-order traversal of
 * the binary tree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
public class _0114_FlattenBinaryTreeToLinkedList {
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
        public void flatten(TreeNode root) {
            if (root == null){
                return;
            }
            List<TreeNode> list = new ArrayList<>();
            preTravel(root, list);
            for (int i = 0; i < list.size() - 1; i++){
                TreeNode cur = list.get(i);
                cur.right = list.get(i + 1);
                cur.left = null;
            }
        }

        private void preTravel(TreeNode node, List<TreeNode> list){
            if (node == null){
                return;
            }
            list.add(node);
            preTravel(node.left, list);
            preTravel(node.right, list);
        }
    }
}
// @lc code=end

