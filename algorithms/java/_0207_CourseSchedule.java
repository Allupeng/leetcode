/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.cn/problems/course-schedule/description/
 *
 * algorithms
 * Medium (53.88%)
 * Likes:    1822
 * Dislikes: 0
 * Total Accepted:    352.6K
 * Total Submissions: 654.4K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i]
 * = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * 
 * 
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0207_CourseSchedule {
// @lc code=start
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, Integer> inDegree = new HashMap<>();
            for (int i = 0; i < numCourses; i++){
                inDegree.put(i, 0);
            }
            Map<Integer, List<Integer>> dependency = new HashMap<>();
            for (int[] pre : prerequisites){
                int cur = pre[1];
                int next = pre[0];
                inDegree.put(next, inDegree.get(next) + 1);
                List<Integer> list = dependency.get(cur);
                if (list == null){
                    list = new ArrayList<>();
                }
                list.add(next);
                dependency.put(cur, list);
            }

            Queue<Integer> queue = new LinkedList<>();
            for (Integer key : inDegree.keySet()){
                if (inDegree.get(key) == 0){
                    queue.offer(key);
                }
            }
            while (!queue.isEmpty()){
                int cur = queue.poll();
                if (!dependency.containsKey(cur)){
                    continue;
                }
                List<Integer> nextList = dependency.get(cur);
                for (Integer next : nextList){
                    int value = inDegree.get(next) - 1;
                    if (value == 0){
                        queue.offer(next);
                    }
                    inDegree.put(next, value);
                }
            }

            for (Integer key : inDegree.keySet()){
                if (inDegree.get(key) != 0){
                    return false;
                }
            }
            return true;
        }
    }
// @lc code=end
}
