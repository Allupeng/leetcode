/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 *
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 *
 * algorithms
 * Easy (50.82%)
 * Likes:    369
 * Dislikes: 0
 * Total Accepted:    133.1K
 * Total Submissions: 262K
 * Testcase Example:  '[4,2,3]\n1'
 *
 * Given an integer array nums and an integer k, modify the array in the
 * following way:
 * 
 * 
 * choose an index i and replace nums[i] with -nums[i].
 * 
 * 
 * You should apply this process exactly k times. You may choose the same index
 * i multiple times.
 * 
 * Return the largest possible sum of the array after modifying it in this
 * way.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,2,3], k = 1
 * Output: 5
 * Explanation: Choose index 1 and nums becomes [4,-2,3].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,-1,0,2], k = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,-3,-1,5,-4], k = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 * 
 * 
 */

import java.util.Arrays;

public class _1005_MaximizeSumOfArrayAfterKNegations {
// @lc code=start
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            int sum = 0;
            Arrays.sort(nums);
            int negatives = 0;
            for (int num : nums){
                if (num < 0) negatives++;
            }
            int index = 0;
            while (negatives > 0 && k > 0){
                nums[index] = -nums[index];
                index++;
                negatives--;
                k--;
            }
            Arrays.sort(nums);
            if (k > 0){
                k = k % 2;
                if (k == 1){
                    nums[0] = -nums[0];
                }
            }
            for (int num : nums) sum += num;
            return sum;
        }
    }
// @lc code=end
}

