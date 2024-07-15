package hot100;/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.cn/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (60.11%)
 * Likes:    4952
 * Dislikes: 0
 * Total Accepted:    1.3M
 * Total Submissions: 2.1M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * You are given an integer array height of length n. There are n vertical
 * lines drawn such that the two endpoints of the i^th line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * 
 */

public class _0011_ContainerWithMostWater {
// @lc code=start
    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0, right = height.length - 1;
            while (left < right) {
                int h = Math.min(height[left], height[right]);
                int w = right - left;
                maxArea = Math.max(maxArea, w * h);
                if (height[left] < height[right]) {
                    left++;
                }else{
                    right--;
                }
            }
            return maxArea;
        }
    }
// @lc code=end
}

