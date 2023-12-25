/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 *
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (68.36%)
 * Likes:    1099
 * Dislikes: 0
 * Total Accepted:    347.8K
 * Total Submissions: 508.9K
 * Testcase Example:  '[6,2,8,0,4,7,9,null,null,3,5]\n2\n8'
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
 * of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of
 * itself).”
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 * 
 * 
 */


public class _0235_LowestCommonAncestorOfABinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
// @lc code=start
    class Solution {
    /**
     * 从根节点开始，将目标节点1和目标节点2与当前节点进行比较。
     *
     * 如果当前节点的值大于目标节点1和目标节点2的值，说明它们都在当前节点的左子树中，因此继续在左子树中递归查找。
     *
     * 如果当前节点的值小于目标节点1和目标节点2的值，说明它们都在当前节点的右子树中，因此继续在右子树中递归查找。
     *
     * 如果当前节点的值介于目标节点1和目标节点2的值之间，或者当前节点的值等于其中一个目标节点的值，说明当前节点就是最近公共祖先。
     */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > Math.max(p.val, q.val)){
                // 说明 p、q在左子树当中
                return lowestCommonAncestor(root.left, p, q);
            }else if (root.val < Math.min(p.val, q.val)){
                // 说明 p、q在右子树当中
                return lowestCommonAncestor(root.right, p, q);
            }else {
                return root;
            }
        }
    }
// @lc code=end
}

