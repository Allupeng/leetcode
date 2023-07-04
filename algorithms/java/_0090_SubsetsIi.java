/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.cn/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (63.62%)
 * Likes:    1118
 * Dislikes: 0
 * Total Accepted:    306.7K
 * Total Submissions: 482K
 * Testcase Example:  '[1,2,2]'
 *
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_SubsetsIi {
// @lc code=start
    class Solution {
        private final List<Integer> path = new ArrayList<>();

        private final List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0 ){
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            backtrace(nums, 0, new boolean[nums.length]);
            return result;
        }

        private void backtrace(int[] nums, int startIndex, boolean[] used){
            result.add(new ArrayList<>(path));
            if (startIndex > nums.length){
                return;
            }
            for (int i = startIndex; i < nums.length; i++){
                // duplicate element
                if (i - 1 >= 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backtrace(nums, i + 1, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
// @lc code=end
}

