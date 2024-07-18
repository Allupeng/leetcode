/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.cn/problems/permutations/description/
 *
 * algorithms
 * Medium (79.16%)
 * Likes:    2875
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.3M
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
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            backtrace(nums, new boolean[nums.length], new ArrayList<>(), result);
            return result;
        }

        private void backtrace(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result){
            if (list.size() == nums.length){
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++){
                if (visited[i]){
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                backtrace(nums, visited, list, result);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
// @lc code=end
}

