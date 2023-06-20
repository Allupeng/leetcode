/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (72.87%)
 * Likes:    378
 * Dislikes: 0
 * Total Accepted:    155.6K
 * Total Submissions: 213.5K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
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
 * Output: [[1],[3,2,4],[5,6]]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0429_NAryTreeLevelOrderTraversal {

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
    };

// @lc code=start
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            // n叉树的层序遍历与二叉树的层序遍历区别在于最后加入孩子结点入队列那一步
            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    Node cur = queue.poll();
                    if (cur == null){
                        continue;
                    }
                    list.add(cur.val);
                    List<Node> children = cur.children;
                    for (Node child : children){
                        if (child == null){
                            continue;
                        }
                        queue.offer(child);
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
// @lc code=end
}

