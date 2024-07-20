/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (45.70%)
 * Likes:    2713
 * Dislikes: 0
 * Total Accepted:    412.1K
 * Total Submissions: 901.8K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle
 * in the histogram.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10
 * units.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: heights = [2,4]
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 * 
 * 
 */

import java.util.Stack;

public class _0084_LargestRectangleInHistogram {
// @lc code=start
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // find next smaller one
            Stack<Integer> stack = new Stack<>();
            int maxArea = 0;
            // use sentinel
            for (int i = 0; i <= heights.length; i++){
                int h = (i == heights.length) ? 0 : heights[i];
                while (!stack.isEmpty() && h < heights[stack.peek()]){
                    // i-index is the smaller one
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    System.out.println(String.format("i is %s height is %s, width is %s, area = %s", i, height, width, height * width));
                    maxArea = Math.max(height * width, maxArea);
                }
                stack.push(i);
            }
            return maxArea;
        }
    }
// @lc code=end
}

