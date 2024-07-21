/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.cn/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (75.87%)
 * Likes:    1148
 * Dislikes: 0
 * Total Accepted:    511K
 * Total Submissions: 673.5K
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0118_PascalsTriangle {
// @lc code=start
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.singletonList(1));
            for (int i = 1; i < numRows; i++){
                List<Integer> pre = result.get(i - 1);
                List<Integer> list = new ArrayList<>();
                for(int j = 0; j <= i; j++){
                    int topElement = (0 <= j && j < pre.size()) ? pre.get(j) : 0;
                    int topLeftElement = (0 <= j - 1 && j - 1 < pre.size()) ? pre.get(j - 1) : 0;
                    int cur = topElement + topLeftElement;
                    list.add(cur);
                }
                result.add(list);
            }
            return result;
        }
    }
// @lc code=end
}

