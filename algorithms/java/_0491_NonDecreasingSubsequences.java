/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] Non-decreasing Subsequences
 *
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/
 *
 * algorithms
 * Medium (52.03%)
 * Likes:    677
 * Dislikes: 0
 * Total Accepted:    140K
 * Total Submissions: 269.1K
 * Testcase Example:  '[4,6,7,7]'
 *
 * Given an integer array nums, return all the different possible
 * non-decreasing subsequences of the given array with at least two elements.
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0491_NonDecreasingSubsequences {
// @lc code=start
    class Solution {

        private final List<Integer> path = new ArrayList<>();

        private final List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            if (nums.length == 0){
                return result;
            }
            backtrace(nums, 0);
            return result;
        }

        private void backtrace(int[] nums, int startIndex){
            if (startIndex > nums.length){
                return;
            }
            // 保证有一个元素
            if (path.size() >= 2){
                result.add(new ArrayList<>(path));
            }
            Set<Integer> used = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++){
                if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1))
                        || used.contains(nums[i])){
                    continue;
                }
                used.add(nums[i]);
                path.add(nums[i]);
                backtrace(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
// @lc code=end
}

