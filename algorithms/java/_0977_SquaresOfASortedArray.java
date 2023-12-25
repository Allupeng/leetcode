/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.cn/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (68.00%)
 * Likes:    807
 * Dislikes: 0
 * Total Accepted:    536.6K
 * Total Submissions: 789.1K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 * 
 * 
 * 
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */

public class _0977_SquaresOfASortedArray{
// @lc code=start
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];
            int left = 0, right = nums.length - 1;
            int index = nums.length - 1;
            while(left <= right){
                if(Math.abs(nums[left]) <= Math.abs(nums[right])){
                    result[index] = nums[right] * nums[right];
                    right--;
                }else{
                    result[index] = nums[left] * nums[left];
                    left++;
                }
                index--;
            }
            return result;
        }
    }
// @lc code=end
}

