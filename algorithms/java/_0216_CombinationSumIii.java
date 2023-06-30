/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (71.52%)
 * Likes:    696
 * Dislikes: 0
 * Total Accepted:    275.4K
 * Total Submissions: 385K
 * Testcase Example:  '3\n7'
 *
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * 
 * 
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is
 * 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= k <= 9
 * 1 <= n <= 60
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0216_CombinationSumIii {
// @lc code=start
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> tmp = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            traversal(1, k, n, tmp, result);
            return result;
        }

        private void traversal(int cur, int k ,int n, List<Integer> tmp, List<List<Integer>> result){
            if (tmp.size() == k && sum(tmp) == n){
                result.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = cur; i <= 9; i++){
                tmp.add(i);
                traversal(i + 1, k, n, tmp, result);
                tmp.remove(tmp.size() - 1);
            }
        }

        private int sum(List<Integer> tmp){
            int sum = 0;
            for (Integer t : tmp){
                sum += t;
            }
            return sum;
        }
    }
// @lc code=end
}

