/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.cn/problems/partition-labels/description/
 *
 * algorithms
 * Medium (76.88%)
 * Likes:    1127
 * Dislikes: 0
 * Total Accepted:    229.2K
 * Total Submissions: 298.1K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * 
 * Note that the partition is done so that after concatenating all the parts in
 * order, the resultant string should be s.
 * 
 * Return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits s into less parts.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _0763_PartitionLabels {
// @lc code=start
    class Solution {
        public List<Integer> partitionLabels(String s) {
            if (s.isEmpty()) return new ArrayList<>();
            int[] last = new int[26];
            for (int i = 0; i < s.length(); i++){
                last[s.charAt(i) - 'a'] = i;
            }
            int start = 0, end = 0;
            List<Integer> partition = new ArrayList<>();
            for (int i = 0; i < s.length(); i++){
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end){
                    partition.add(end - start + 1);
                    start = i + 1;
                }
            }
            return partition;
        }
    }
// @lc code=end
}

