 /*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (49.94%)
 * Likes:    2312
 * Dislikes: 0
 * Total Accepted:    849.9K
 * Total Submissions: 1.7M
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056_MergeIntervals {
// @lc code=start
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 1) return intervals;
            Arrays.sort(intervals, (intervals1, intervals2)->{
                if(intervals1[0] ==  intervals2[0]){
                    return intervals1[1] - intervals2[1];
                }
                return intervals1[0] - intervals2[0];
            });

            List<int[]> list = new ArrayList<>();
            list.add(intervals[0]);
            for(int i = 1; i < intervals.length; i++){
                int[] pre = list.get(list.size() - 1);
                int[] cur = intervals[i];
                //[1, 3] [2, 4]
                //[1, 4] [2, 3]
                if (pre[1] >= cur[0]) {
                    if(pre[1] > cur[1]){
                        // do noting
                    }else{
                        list.remove(list.size() - 1);
                        list.add(new int[]{pre[0], cur[1]});
                    }
                }else{
                    list.add(cur);
                }
            }
            int[][] result = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
            return result;
        }
    }
// @lc code=end
}
