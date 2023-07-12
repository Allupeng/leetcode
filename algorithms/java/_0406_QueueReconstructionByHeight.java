/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.cn/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (76.31%)
 * Likes:    1652
 * Dislikes: 0
 * Total Accepted:    252.2K
 * Total Submissions: 330.5K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * You are given an array of people, people, which are the attributes of some
 * people in a queue (not necessarily in order). Each people[i] = [hi, ki]
 * represents the i^th person of height hi with exactly ki other people in
 * front who have a height greater than or equal to hi.
 * 
 * Reconstruct and return the queue that is represented by the input array
 * people. The returned queue should be formatted as an array queue, where
 * queue[j] = [hj, kj] is the attributes of the j^th person in the queue
 * (queue[0] is the person at the front of the queue).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * Explanation:
 * Person 0 has height 5 with no other people taller or the same height in
 * front.
 * Person 1 has height 7 with no other people taller or the same height in
 * front.
 * Person 2 has height 5 with two persons taller or the same height in front,
 * which is person 0 and 1.
 * Person 3 has height 6 with one person taller or the same height in front,
 * which is person 1.
 * Person 4 has height 4 with four people taller or the same height in front,
 * which are people 0, 1, 2, and 3.
 * Person 5 has height 7 with one person taller or the same height in front,
 * which is person 1.
 * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= people.length <= 2000
 * 0 <= hi <= 10^6
 * 0 <= ki < people.length
 * It is guaranteed that the queue can be reconstructed.
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0406_QueueReconstructionByHeight {
// @lc code=start
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (people1, people2)->{
                // 先按照h降序，再按照k升序
                // * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
                // * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
                if (people1[0] == people2[0]){
                    return people1[1] - people2[1];
                }else {
                    return people2[0] - people1[0];
                }
            });
            List<List<Integer>> peoples = new ArrayList<>();
            for (int[] cur : people) {
                List<Integer> curPeople = new ArrayList<>();
                curPeople.add(cur[0]);
                curPeople.add(cur[1]);
                peoples.add(cur[1], curPeople);
            }

            int[][] result = new int[peoples.size()][2];
            int index = 0;
            for (List<Integer> cell : peoples){
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
        int[][] people = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        Solution solution = new Solution();
        solution.reconstructQueue(people);
    }
}

