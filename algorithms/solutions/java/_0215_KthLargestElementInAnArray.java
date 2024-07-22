/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (61.49%)
 * Likes:    2450
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.7M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Given an integer array nums and an integer k, return the k^th largest
 * element in the array.
 * 
 * Note that it is the k^th largest element in the sorted order, not the k^th
 * distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

import java.util.PriorityQueue;

public class _0215_KthLargestElementInAnArray {
// @lc code=start
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 0) return 0;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
            for (int num : nums){
                if (minHeap.size() < k){
                    minHeap.offer(num);
                }else if (num >= minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
            return minHeap.peek();
        }
    }
// @lc code=end
}

