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
import java.util.Map;
import java.util.PriorityQueue;

public class _0347_TopKFrequentElements {
// @lc code=start
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            Map<Integer, Integer> frequent = new HashMap<>();
            for (int num : nums) {
                frequent.put(num, frequent.getOrDefault(num , 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry: frequent.entrySet()){
                int[] tmp = new int[2];
                tmp[0] = entry.getKey();
                tmp[1] = entry.getValue();
                minHeap.offer(tmp);
                if (minHeap.size() > k){
                    minHeap.poll();
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++){
                result[i] = minHeap.poll()[0];
            }
            return result;
        }
    }
// @lc code=end
}

