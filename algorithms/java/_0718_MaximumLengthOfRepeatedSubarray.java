/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 *
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (56.88%)
 * Likes:    971
 * Dislikes: 0
 * Total Accepted:    200.7K
 * Total Submissions: 352.9K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * Given two integer arrays nums1 and nums2, return the maximum length of a
 * subarray that appears in both arrays.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 * Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * 
 * 
 */

public class _0718_MaximumLengthOfRepeatedSubarray {
    // @lc code=start
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            //dp[i][j] 代表以下标为i - 1,j - 1字符结尾的最长重复子数组的长度
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int result = 0;
            dp[0][0] = 0;
            for (int i = 1; i <= nums1.length; i++){
                for (int j = 1; j <= nums2.length; j++){
                    if (nums1[i - 1] == nums2[j - 1]){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
            return result;
        }
    }
// @lc code=end
}

