/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.cn/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (63.53%)
 * Likes:    1577
 * Dislikes: 0
 * Total Accepted:    434.6K
 * Total Submissions: 684.1K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * 
 * 
 * 
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * 
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0347_TopKFrequentElements {
// @lc code=start
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            Map<Integer, Integer> frequentMap = new HashMap<>();
            for (int num : nums){
                frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()){
                int[] ints = new int[2];
                ints[0] = entry.getKey();
                ints[1] = entry.getValue();
                minHeap.offer(ints);
                if (minHeap.size() > k){
                    minHeap.poll();
                }
            }
            int[] result = new int[k];
            int i = 0;
            while (!minHeap.isEmpty()){
                result[i] = minHeap.poll()[0];
                i++;
            }
            return result;
        }
    }
// @lc code=end
}

