 /*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.07%)
 * Likes:    2330
 * Dislikes: 0
 * Total Accepted:    451.4K
 * Total Submissions: 1M
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an
 * array.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

public class _0560_SubarraySumEqualsK {
// @lc code=start
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // pre[i] = sum[0, i - 1]
            // sum[j, i] = pre[i + 1] - pre[j]
            int[] pre = new int[nums.length + 1];
            for(int i = 1; i <= nums.length; i++){
                pre[i] = pre[i - 1] + nums[i - 1];
            }
            int cnt = 0;
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j <= i; j++){
                    int target = pre[i + 1] - pre[j];
                    if (k == target) {
                        cnt++;
                    }
                    System.out.println(String.format("i:%s, j:%s target:%s", i, j, target));
                }
            }
            return cnt;
        }
    }
// @lc code=end
}
