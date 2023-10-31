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
            if (intervals.length == 1){
                return intervals;
            }
            Arrays.sort(intervals, ((o1, o2) -> {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }));
            List<int[]> result = new ArrayList<>();
            result.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++){
                int[] last = result.get(result.size() - 1);
                int[] cur = intervals[i];
                // 有重叠部分，进行区间合并
                if (last[1] >= cur[0]){
                    if (last[1] < cur[1]){
                        int[] newInterval = new int[]{last[0], cur[1]};
                        result.remove(result.size() - 1);
                        result.add(newInterval);
                    }
                }else{
                    result.add(cur);
                }
            }
            return result.toArray(new int[result.size()][]);
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

