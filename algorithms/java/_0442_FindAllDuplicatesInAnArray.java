/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 *
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/description/
 *
 * algorithms
 * Medium (75.10%)
 * Likes:    744
 * Dislikes: 0
 * Total Accepted:    114.2K
 * Total Submissions: 152K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an integer array nums of length n where all the integers of nums are
 * in the range [1, n] and each integer appears once or twice, return an array
 * of all the integers that appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant
 * extra space.
 * 
 * 
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 * Input: nums = [1]
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0442_FindAllDuplicatesInAnArray {
    // @lc code=start
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            // 因为 1 <= nums[i] <= n, 而 n == nums.length
            // 而数组下标由 0
            // 所以将 nums[i]和一个下标进行映射。如果下标映射的值已经变化了，说明有重复的数字出现
            List<Integer> result = new ArrayList<>();
            if (nums.length == 0){
                return result;
            }
            for (int i = 0; i < nums.length; i++){
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0){
                    nums[idx] *= -1;
                }else{
                    result.add(Math.abs(nums[i]));
                }
            }
            return result;
        }
    }
// @lc code=end
}

