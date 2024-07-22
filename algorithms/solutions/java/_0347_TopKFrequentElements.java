/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.cn/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (63.65%)
 * Likes:    1825
 * Dislikes: 0
 * Total Accepted:    544.5K
 * Total Submissions: 855.4K
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

import java.util.*;

public class _0347_TopKFrequentElements {
// @lc code=start
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequentMap = new HashMap<>();
            for (int num : nums){
                int frequent = frequentMap.getOrDefault(num, 0);
                frequentMap.put(num, frequent + 1);
            }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(frequentMap::get));
            for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()){
                minHeap.offer(entry.getKey());
                if (minHeap.size() > k){
                    minHeap.poll();
                }
            }
            List<Integer> list = new ArrayList<>();
            while (!minHeap.isEmpty()){
                list.add(minHeap.poll());
            }
            Collections.reverse(list);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
// @lc code=end
}
