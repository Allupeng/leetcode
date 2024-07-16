/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (63.47%)
 * Likes:    5139
 * Dislikes: 0
 * Total Accepted:    942.9K
 * Total Submissions: 1.5M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

public class _0042_TrappingRainWater {
// @lc code=start
    class Solution {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int[] leftMaxDP = new int[height.length];
            for (int i = 1; i < height.length; i++){
                leftMaxDP[i] = Math.max(leftMaxDP[i - 1], height[i - 1]);
            }
            int[] rightMaxDP = new int[height.length];
            for (int i = height.length - 2; i >= 0; i--){
                rightMaxDP[i] = Math.max(rightMaxDP[i + 1], height[i + 1]);
            }
            int totalWater = 0;
            for (int i = 1; i < height.length - 1; i++){
                int h = Math.min(leftMaxDP[i], rightMaxDP[i]);
                if (h - height[i] > 0) {
                    totalWater += h - height[i];
                }
            }
            return totalWater;
        }
    }
// @lc code=end
}
