/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] Jump Game
 *
 * https://leetcode.cn/problems/jump-game/description/
 *
 * algorithms
 * Medium (43.55%)
 * Likes:    2376
 * Dislikes: 0
 * Total Accepted:    729.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * 
 * Return true if you can reach the last index, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 * 
 * 
 */

public class _0055_JumpGame {
// @lc code=start
    class Solution {
        public boolean canJump(int[] nums) {
            // 每次都尽可能的选择最大长度进行跳跃
            // 当前能到达的最远位置
            int maxSearch = 0;
            for (int i = 0; i < nums.length; i++){
                if (i > maxSearch){
                    return false;
                }
                maxSearch = Math.max(maxSearch, i + nums[i]);
            }
            return true;
        }
    }
// @lc code=end
}

