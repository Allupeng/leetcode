/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.cn/problems/subsets/description/
 *
 * algorithms
 * Medium (81.26%)
 * Likes:    2281
 * Dislikes: 0
 * Total Accepted:    778.7K
 * Total Submissions: 958.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0078_Subsets {
// @lc code=start
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if(nums.length == 0) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            backtrace(nums, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrace(int[] nums, int curIndex, List<Integer> list, List<List<Integer>> result){
            if (curIndex > nums.length){
                return;
            }
            result.add(new ArrayList<>(list));
            for (int i = curIndex; i < nums.length; i++){
                list.add(nums[i]);
                backtrace(nums, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
// @lc code=end
}

