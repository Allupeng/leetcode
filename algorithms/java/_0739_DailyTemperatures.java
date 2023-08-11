/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.cn/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (68.84%)
 * Likes:    1566
 * Dislikes: 0
 * Total Accepted:    450.2K
 * Total Submissions: 653.9K
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

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class _0739_DailyTemperatures {
// @lc code=start
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];
            // stack存储着当前元素的下标
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++){
                /**
                 * 1. 如果栈 empty,将元素加入栈
                 * 2. 如果栈不为null,
                 * 如果当前元素大于栈顶元素，栈顶元素弹出（找到了下一个比他大的）
                 * 如果当前元素小于栈顶元素，当前元素弹入栈内
                 */
                while (!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])){
                    int prev = stack.pop();
                    result[prev] = i - prev;
                }
                stack.push(i);
            }
            return result;
        }
    }
// @lc code=end
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] items1 = new int[]{30,40,50,60};
        arrayEquals(new int[]{1,1,1,0},solution.dailyTemperatures(items1));

        int[] items2 = new int[]{73,74,75,71,69,72,76,73};
        arrayEquals(new int[]{1,1,4,2,1,1,0,0},solution.dailyTemperatures(items2));
    }

    private boolean arrayEquals(int[] expected, int[] actual){
        if (expected.length != actual.length){
            return false;
        }
        for (int i = 0; i < expected.length; i++){
            Assert.assertEquals(expected[i], actual[i]);
        }
        return true;
    }
}

