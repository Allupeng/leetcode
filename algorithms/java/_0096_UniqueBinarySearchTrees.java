/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (70.86%)
 * Likes:    2316
 * Dislikes: 0
 * Total Accepted:    380.9K
 * Total Submissions: 537.5K
 * Testcase Example:  '3'
 *
 * Given an integer n, return the number of structurally unique BST's (binary
 * search trees) which has exactly n nodes of unique values from 1 to n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 19
 * 
 * 
 */

public class _0096_UniqueBinarySearchTrees {
// @lc code=start
    class Solution {
        public int numTrees(int n) {
            // dp[i] 定义为元素为n = i时不同二叉搜索树的数量
            // n = 3的时候
            // dp[3] = 头节点为1的BST数量 + 头节点为2的BST数量 + 头节点为3的BST数量
            // 头节点为1的BST数量 = 左子树元素为0的BST * 右子树为元素为2的BST
            // 头节点为2的BST数量 = 左子树元素为1的BST * 右子树为元素为1的BST
            // 头节点为3的BST数量 = 左子树元素为2的BST * 右子树为元素为0的BST
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];
            }
            return dp[n];
        }
    }
// @lc code=end


}
