/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.cn/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (68.92%)
 * Likes:    511
 * Dislikes: 0
 * Total Accepted:    284.3K
 * Total Submissions: 412.5K
 * Testcase Example:  '3'
 *
 * Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0119_PascalsTriangleIi {
// @lc code=start
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> last = new ArrayList<>();
            last.add(1);
            if (rowIndex == 0){
                return last;
            }
            List<Integer> cur = new ArrayList<>();
            for (int i = 1; i <= rowIndex; i++){
                cur = new ArrayList<>();
                for (int j = 0; j <= i; j++){
                    int topLeft = j - 1 < 0 ? 0 : last.get(j - 1);
                    int top = j >= last.size() ? 0 : last.get(j);
                    cur.add(top + topLeft);
                }
                last = new ArrayList<>(cur);
            }
            return cur;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.getRow(3);
    }
}

