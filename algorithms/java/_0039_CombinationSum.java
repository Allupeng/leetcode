/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.cn/problems/combination-sum/description/
 *
 * algorithms
 * Medium (72.35%)
 * Likes:    2520
 * Dislikes: 0
 * Total Accepted:    751K
 * Total Submissions: 1M
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * The test cases are generated such that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: candidates = [2], target = 1
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0039_CombinationSum {

// @lc code=start
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            combinations(candidates, 0, 0, target, new ArrayList<>(), result);
            return result;
        }

        private void combinations(int[] candidates, int curSum,int startIndex , int target, List<Integer> tmp, List<List<Integer>> result){
            if (curSum == target){
                result.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++){
                int candidate = candidates[i];
                if (curSum + candidate > target){
                    break;
                }
                tmp.add(candidate);
                combinations(candidates, curSum + candidate, i, target, tmp, result);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(candidates, target);
        System.out.println(lists);
    }
}

