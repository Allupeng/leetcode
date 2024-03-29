/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
 *
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (74.99%)
 * Likes:    348
 * Dislikes: 0
 * Total Accepted:    145.8K
 * Total Submissions: 194.4K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given a n-ary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The total number of nodes is in the range [0, 10^4].
 * The depth of the n-ary tree is less than or equal to 1000.
 * 
 * 
 */

import java.util.List;

public class _0559_MaximumDepthOfNAryTree {
class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // @lc code=start
    class Solution {
        public int maxDepth(Node root) {
            if (root == null){
                return 0;
            }
            return getMaxDepth(root);
        }

        private int getMaxDepth(Node root){
            if (root == null){
                return 0;
            }
            if (root.children == null || root.children.size() == 0){
                return 1;
            }
            int max = 0;
            for (int i = 0; i < root.children.size(); i++){
                Node cur = root.children.get(i);
                max = Math.max(max, getMaxDepth(cur));
            }
            return 1 + max;
        }

    }
// @lc code=end
}

