/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 *
 * https://leetcode.cn/problems/uncrossed-lines/description/
 *
 * algorithms
 * Medium (70.53%)
 * Likes:    474
 * Dislikes: 0
 * Total Accepted:    84.8K
 * Total Submissions: 120.2K
 * Testcase Example:  '[1,4,2]\n[1,2,4]'
 *
 * You are given two integer arrays nums1 and nums2. We write the integers of
 * nums1 and nums2 (in the order they are given) on two separate horizontal
 * lines.
 * 
 * We may draw connecting lines: a straight line connecting two numbers
 * nums1[i] and nums2[j] such that:
 * 
 * 
 * nums1[i] == nums2[j], and
 * the line we draw does not intersect any other connecting (non-horizontal)
 * line.
 * 
 * 
 * Note that a connecting line cannot intersect even at the endpoints (i.e.,
 * each number can only belong to one connecting line).
 * 
 * Return the maximum number of connecting lines we can draw in this way.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,4,2], nums2 = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to
 * nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * Output: 3
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 500
 * 1 <= nums1[i], nums2[j] <= 2000
 * 
 * 
 */

public class _1035_UncrossedLines {
// @lc code=start
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            //该题转化为 求取最长公共子序列问题
            // dp[i][j] 代表以i-1,j-1字符结尾时的最长公共子序列长度
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= nums1.length; i++){
                for (int j = 1; j <= nums2.length; j++){
                    if (nums1[i - 1] == nums2[j - 1]){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[nums1.length][nums2.length];
        }
    }
// @lc code=end
}

