/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.cn/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (59.74%)
 * Likes:    1368
 * Dislikes: 0
 * Total Accepted:    438.2K
 * Total Submissions: 733.5K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: 
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: 
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_CombinationSumIi {
// @lc code=start
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 0){
                return new ArrayList<>();
            }
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            boolean[] used = new boolean[candidates.length];
            combinations(0, target, candidates, 0, new ArrayList<>(), result, used);
            return result;
        }

        private void combinations(int curSum, int target, int[] candidates, int index, List<Integer> path, List<List<Integer>> result, boolean[] used){
            if (curSum > target){
                return;
            }
            if (curSum == target){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < candidates.length; i++){
                // 通过used[i - 1] == false 来判断是否重复元素
                if (i - 1 >= 0 && candidates[i - 1] == candidates[i] && used[i - 1] == false){
                    continue;
                }
                curSum += candidates[i];
                path.add(candidates[i]);
                used[i] = true;
                combinations(curSum, target, candidates, i + 1, path, result, used);
                curSum -= candidates[i];
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
// @lc code=end

}
