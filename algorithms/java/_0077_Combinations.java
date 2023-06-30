/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.cn/problems/combinations/description/
 *
 * algorithms
 * Medium (77.12%)
 * Likes:    1413
 * Dislikes: 0
 * Total Accepted:    550.9K
 * Total Submissions: 714.4K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered
 * to be the same combination.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0077_Combinations {
// @lc code=start
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            traversal(1, n, k, path, result);
            return result;
        }

        private void traversal(int cur, int n, int k, List<Integer> path, List<List<Integer>> result){
            if (path.size() == k){
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = cur; i <= n; i++){
                path.add(i);
                traversal(i + 1, n, k, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.combine(4, 2);
    }
}

