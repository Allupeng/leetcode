/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] Maximum Binary Tree
 *
 * https://leetcode.cn/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (82.57%)
 * Likes:    700
 * Dislikes: 0
 * Total Accepted:    201.7K
 * Total Submissions: 244.3K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * You are given an integer array nums with no duplicates. A maximum binary
 * tree can be built recursively from nums using the following algorithm:
 * 
 * 
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the
 * maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of
 * the maximum value.
 * 
 * 
 * Return the maximum binary tree built from nums.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,2,1,6,0,5]
 * Output: [6,3,5,null,2,0,null,null,1]
 * Explanation: The recursive calls are as follow:
 * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right
 * suffix is [0,5].
 * ⁠   - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix
 * is [2,1].
 * ⁠       - Empty array, so no child.
 * ⁠       - The largest value in [2,1] is 2. Left prefix is [] and right
 * suffix is [1].
 * ⁠           - Empty array, so no child.
 * ⁠           - Only one element, so child is a node with value 1.
 * ⁠   - The largest value in [0,5] is 5. Left prefix is [0] and right suffix
 * is [].
 * ⁠       - Only one element, so child is a node with value 0.
 * ⁠       - Empty array, so no child.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1]
 * Output: [3,null,2,null,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * All integers in nums are unique.
 * 
 * 
 */

public class _0654_MaximumBinaryTree {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums.length == 0){
                return null;
            }
            return buildTreeNodeHelper(nums, 0, nums.length - 1);
        }

        private TreeNode buildTreeNodeHelper(int[] nums, int start, int end){
            if (start > end){
                return null;
            }
            // first step : find the max value in the nums
            int maxValueIndex = findTheMaxIndexInArray(nums, start, end);
            TreeNode root = new TreeNode(nums[maxValueIndex]);

            root.left = buildTreeNodeHelper(nums, start, maxValueIndex - 1);
            root.right = buildTreeNodeHelper(nums, maxValueIndex + 1, end);
            return root;
        }

        private int findTheMaxIndexInArray(int[] nums, int start, int end){
            if (start > end){
                return -1;
            }
            int maxValue = nums[start];
            int maxIndex = start;
            for (int i = start; i <= end; i++){
                if (nums[i] > maxValue){
                    maxIndex = i;
                    maxValue = nums[i];
                }
            }
            return maxIndex;
        }
    }
// @lc code=end
}

