/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (49.37%)
 * Likes:    1945
 * Dislikes: 0
 * Total Accepted:    652.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056_MergeIntervals {
// @lc code=start
    class Solution {
        public int[][] merge(int[][] intervals) {
            int rows = intervals.length;
            if (rows == 1){
                return intervals;
            }
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            });
            List<List<Integer>> cells = new ArrayList<>();
            List<Integer> firstCell = new ArrayList<>();
            firstCell.add(intervals[0][0]);
            firstCell.add(intervals[0][1]);
            cells.add(firstCell);
            for (int i = 1; i < rows; i++){
                List<Integer> lastCell = cells.get(cells.size() - 1);
                List<Integer> cell = new ArrayList<>();
                if (lastCell.get(1) >= intervals[i][0]){
                    // merge cells
                    // [1, 4] [2, 3]
                    cells.remove(cells.size() - 1);
                    cell.add(lastCell.get(0));
                    if (lastCell.get(1) >= intervals[i][1]){
                        cell.add(lastCell.get(1));
                    }else {
                        cell.add(intervals[i][1]);
                    }
                }else {
                    cell.add(intervals[i][0]);
                    cell.add(intervals[i][1]);
                }
                cells.add(cell);
            }
            int[][] result = new int[cells.size()][2];
            int index = 0;
            for (List<Integer> cell : cells){
                result[index][0] = cell.get(0);
                result[index][1] = cell.get(1);
                index++;
            }
            return result;
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        Solution solution = new Solution();
        solution.merge(intervals);
    }
}

