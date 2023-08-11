/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (66.94%)
 * Likes:    845
 * Dislikes: 0
 * Total Accepted:    208.1K
 * Total Submissions: 310.9K
 * Testcase Example:  '[1,2,1]'
 *
 * Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the next greater number for every
 * element in nums.
 * 
 * The next greater number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; 
 * The number 2 can't find next greater number. 
 * The second 1's next greater number needs to search circularly, which is also
 * 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class _0503_NextGreaterElementIi {
// @lc code=start
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            Arrays.fill(result, -1);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length * 2; i++){
                while(!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]){
                    int prev = stack.pop();
                    result[prev] = nums[i % nums.length];
                }
                stack.push(i % nums.length);
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,1};
        Assert.assertArrayEquals(new int[]{2, -1, 2}, solution.nextGreaterElements(nums));
    }

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,3};
        Assert.assertArrayEquals(new int[]{2,3,4,-1,4}, solution.nextGreaterElements(nums));
    }
}

