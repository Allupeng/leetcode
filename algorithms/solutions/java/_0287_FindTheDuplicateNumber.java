/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.cn/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (64.28%)
 * Likes:    2389
 * Dislikes: 0
 * Total Accepted:    383.5K
 * Total Submissions: 596.7K
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * 
 * 
 */

public class _0287_FindTheDuplicateNumber {
// @lc code=start
    class Solution {
        public int findDuplicate(int[] nums) {
            int tortoise = nums[0]; // -> nums[tortoise]
            int rabbit = nums[0]; // -> nums[nums[rabbit]]
            do{
                tortoise = nums[tortoise];
                rabbit = nums[nums[rabbit]];
            }while (tortoise != rabbit);
            tortoise = nums[0];
            while (tortoise != rabbit){
                tortoise = nums[tortoise];
                rabbit = nums[rabbit];
            }
            return tortoise;
        }
    }
// @lc code=end
}
