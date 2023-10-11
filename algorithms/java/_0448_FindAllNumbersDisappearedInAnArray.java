/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (65.79%)
 * Likes:    1272
 * Dislikes: 0
 * Total Accepted:    295.3K
 * Total Submissions: 448.8K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear
 * in nums.
 * 
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 
 * 
 * 
 * Follow up: Could you do it without extra space and in O(n) runtime? You may
 * assume the returned list does not count as extra space.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0448_FindAllNumbersDisappearedInAnArray {
// @lc code=start
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            if (nums.length == 0){
                return new ArrayList<>();
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0){
                    nums[idx] *= -1;
                }
            }
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > 0){
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
// @lc code=end
}

