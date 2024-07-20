/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.cn/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (68.74%)
 * Likes:    1750
 * Dislikes: 0
 * Total Accepted:    544.6K
 * Total Submissions: 792.3K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the i^th day to get a warmer temperature. If there is no future
 * day for which this is possible, keep answer[i] == 0 instead.
 * 
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * 
 * 
 */

import java.util.Stack;

public class _0739_DailyTemperatures {
// @lc code=start
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++){
                // monotonic decreasing stack
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    int preIndex = stack.pop();
                    result[preIndex] = i - preIndex;
                }
                stack.push(i);
            }
            return result;
        }
    }
// @lc code=end
}
