/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] Delete Node in a BST
 *
 * https://leetcode.cn/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (52.36%)
 * Likes:    1172
 * Dislikes: 0
 * Total Accepted:    209.9K
 * Total Submissions: 400.8K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and
 * delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's
 * also accepted.
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [], key = 0
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -10^5 <= key <= 10^5
 * 
 * 
 * 
 * Follow up: Could you solve it with time complexity O(height of tree)?
 * 
 */

public class _0450_DeleteNodeInABst {
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

    /**
     * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
     * 找到删除的节点
     * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
     * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
     * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
     * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
     */
// @lc code=start
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            // 如果没找到删除结点,返回null
            if (root == null) return null;
            if (root.val > key){
                root.left = deleteNode(root.left, key);
            }else if (root.val < key){
                root.right = deleteNode(root.right, key);
            }else {
                // 叶子结点直接删除
                if (root.left == null && root.right == null){
                    return null;
                }else if(root.left != null && root.right == null){
                    // 左结点不为null, 右结点为null
                    // 删除根节点， 左结点补位
                    return root.left;
                }else if (root.left == null && root.right != null){
                    return root.right;
                }else{
                    // 根节点的左子树转移到右子树的最左结点
                    TreeNode leftMost = root.right;
                    while (leftMost.left != null){
                        leftMost = leftMost.left;
                    }
                    //右子树的最左结点 接上待删除结点的左子树
                    leftMost.left = root.left;
                    // 根节点变为右子树
                    root = root.right;
                    return root;
                }
            }
            return root;
        }
    }
// @lc code=end
}

