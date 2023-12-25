/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.cn/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (60.16%)
 * Likes:    4505
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.7M
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

import org.junit.Assert;
import org.junit.Test;

public class _0011_ContainerWithMostWater {
// @lc code=start
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;
            while (left < right){
                int w = right - left;
                int h = Math.min(height[left], height[right]);
                if (height[left] < height[right]){
                    left++;
                }else {
                    right--;
                }
                maxArea = Math.max(w * h, maxArea);
            }
            return maxArea;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(49, solution.maxArea(height));
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] height = new int[]{1,1};
        Assert.assertEquals(1, solution.maxArea(height));
    }
}

