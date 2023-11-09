/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (45.08%)
 * Likes:    2522
 * Dislikes: 0
 * Total Accepted:    356.6K
 * Total Submissions: 791.1K
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
            //找每个元素左边小于该元素的下标,右边小于该元素的下标
            Stack<Integer> stack = new Stack<>();
            int[] tmp = new int[heights.length + 2];
            System.arraycopy(heights, 0, tmp, 1, heights.length);
            heights = tmp;
            int maxArea = 0;
            // 递减单调栈
            stack.push(0);
            for (int i = 1; i < heights.length; i++){
                if (heights[i] > heights[stack.peek()]){
                    stack.push(i);
                }else if (heights[i] == heights[stack.peek()]){
                    stack.pop();
                    stack.push(i);
                }else {
                    while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                        int mid = stack.pop();
                        if (!stack.isEmpty()){
                            int left = stack.peek();
                            int w = i - left - 1;
                            int h = heights[mid];
                            maxArea = Math.max(w * h, maxArea);
                        }
                    }
                    stack.push(i);
                }
            }
            return maxArea;
        }
    }
// @lc code=end

}
