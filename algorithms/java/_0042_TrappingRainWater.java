/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (63.02%)
 * Likes:    4601
 * Dislikes: 0
 * Total Accepted:    740.6K
 * Total Submissions: 1.2M
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

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class _0042_TrappingRainWater {
// @lc code=start
    class Solution {
        public int trap(int[] height) {
            int totalWater = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 1; i < height.length; i++){
                if (height[i] < height[stack.peek()]){
                    stack.push(i);
                }else if (height[i] == height[stack.peek()]){
                    stack.pop();
                    stack.push(i);
                }else {
                    while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                        int mid = stack.pop();
                        if (!stack.isEmpty()){
                            // left为左凹槽，i为右凹槽，mid为当前接雨水的地址
                            int left = stack.peek();
                            int h = Math.min(height[left], height[i]) - height[mid];
                            int w = i - left - 1;
                            totalWater += h * w;
                        }
                    }
                    stack.push(i);
                }
            }
            return totalWater;
        }
    }
// @lc code=end

    /**
     * 双指针暴力法
     * 时间复杂度O(n平方)
     */
    private int brutalTrap(int[] height){
        // 求出除第一列和最后一列以外的每一列的左边最高高度和右边最高高度
        int totalWater = 0;
        for (int i = 0; i < height.length; i++){
            if (i == 0 || i == height.length - 1) continue;
            int leftMax = 0, rightMax = 0;
            for (int left = 0; left < i; left++){
                leftMax = Math.max(leftMax, height[left]);
            }
            for (int right = height.length - 1; right > i; right--){
                rightMax = Math.max(rightMax, height[right]);
            }
            totalWater += Math.max(Math.min(leftMax, rightMax) - height[i], 0);
        }
        return totalWater;
    }

    @Test
    public void testBrutalTrap(){
        int[] height1 = new int[]{4,2,0,3,2,5};
        Assert.assertEquals(9, brutalTrap(height1));

        int[] height3 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6, brutalTrap(height3));
    }

    /**
     * 使用动态规划解决接雨水问题
     * 时间复杂度O(n)
     */
    private int solveTrapByDP(int[] height){
        int totalWater = 0;
        //leftMaxDP[i] 代表是 height[i]的左边最大高度
        int[] leftMaxDP = new int[height.length];
        //rightMaxDP[i] 代表是 height[i]的右边最大高度
        int[] rightMaxDP = new int[height.length];
        for (int i = 0; i < height.length; i++){
            if (i == 0 || i == height.length - 1) continue;
            leftMaxDP[i] = Math.max(leftMaxDP[i - 1], height[i - 1]);
        }
        for (int j = height.length - 1; j >= 0; j--){
            if (j == 0 || j == height.length - 1) continue;
            rightMaxDP[j] = Math.max(rightMaxDP[j + 1], height[j + 1]);
        }
        for (int i = 0; i < height.length; i++){
            totalWater += Math.max(Math.min(leftMaxDP[i], rightMaxDP[i]) - height[i], 0);
        }
        return totalWater;
    }

    @Test
    public void testDPTrap(){
        int[] height1 = new int[]{4,2,0,3,2,5};
        Assert.assertEquals(9, solveTrapByDP(height1));

        int[] height3 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6, solveTrapByDP(height3));
    }

    private int solveTrapByMonotonicStack(int[] height){
        int totalWater = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++){
            if (height[i] < height[stack.peek()]){
                stack.push(i);
            }else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        // left为左凹槽，i为右凹槽，mid为当前接雨水的地址
                        int left = stack.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        totalWater += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return totalWater;
    }

    @Test
    public void testMonotonicStackTrap(){
        int[] height1 = new int[]{4,2,0,3,2,5};
        Assert.assertEquals(9, solveTrapByMonotonicStack(height1));

        int[] height3 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6, solveTrapByMonotonicStack(height3));
    }
}

