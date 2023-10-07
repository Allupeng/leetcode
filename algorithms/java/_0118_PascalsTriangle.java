/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.cn/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (75.50%)
 * Likes:    1071
 * Dislikes: 0
 * Total Accepted:    446.2K
 * Total Submissions: 591K
 * Testcase Example:  '5'
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numRows <= 30
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0118_PascalsTriangle {
// @lc code=start
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> first = new ArrayList<>();
            first.add(1);
            result.add(first);
            for (int i = 2; i <= numRows; i++){
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < i; j++){
                    List<Integer> last = result.get(i - 2);
                    int left = j - 1;
                    int leftValue = left < 0 ? 0 : last.get(left);
                    int rightValue = j >= last.size() ? 0 : last.get(j);
                    tmp.add(leftValue + rightValue);
                }
                result.add(tmp);
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.generate(2);
    }
}

