/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.cn/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (65.53%)
 * Likes:    1393
 * Dislikes: 0
 * Total Accepted:    466.3K
 * Total Submissions: 711.5K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_PermutationsIi {
// @lc code=start
    class Solution {
        private final List<Integer> path = new ArrayList<>();

        private final List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums.length == 0){
                return result;
            }
            Arrays.sort(nums);
            backtrace(nums, new boolean[nums.length]);
            return result;
        }

        private void backtrace(int[] nums, boolean[] used){
            if (path.size() == nums.length){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }
                if (!used[i]){
                    used[i] = true;
                    path.add(nums[i]);
                    backtrace(nums, used);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
// @lc code=end
}

