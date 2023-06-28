/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (77.44%)
 * Likes:    1331
 * Dislikes: 0
 * Total Accepted:    365.2K
 * Total Submissions: 471.6K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given an integer array nums where the elements are sorted in ascending
 * order, convert it to a height-balanced binary search tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
 * 
 * 
 */


public class _0108_ConvertSortedArrayToBinarySearchTree {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            return buildBSTHelper(nums, 0, nums.length - 1);
        }

        private TreeNode buildBSTHelper(int[] nums, int start, int end){
            if (start > end) return null;
            int mid = start + ((end - start) / 2);
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildBSTHelper(nums, start, mid - 1);
            node.right = buildBSTHelper(nums, mid + 1, end);
            return node;
        }
    }
// @lc code=end
}

