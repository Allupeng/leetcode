/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.cn/problems/permutations/description/
 *
 * algorithms
 * Medium (78.88%)
 * Likes:    2597
 * Dislikes: 0
 * Total Accepted:    883.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0046_Permutations {
// @lc code=start
    class Solution {
        private final List<Integer> path = new ArrayList<>();

        private final List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0){
                return result;
            }
            backtrace(nums, new boolean[nums.length]);
            return result;
        }

        private void backtrace(int[] nums, boolean[] used){
            if (path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++){
                if (used[i]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtrace(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }



    }
// @lc code=end
}

