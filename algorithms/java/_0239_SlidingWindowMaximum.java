/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] Sliding Window Maximum
 *
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (49.69%)
 * Likes:    2334
 * Dislikes: 0
 * Total Accepted:    448.7K
 * Total Submissions: 903K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */


import java.util.Deque;
import java.util.LinkedList;

public class _0239_SlidingWindowMaximum {
// @lc code=start
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0){
                return new int[0];
            }
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[n - k + 1];
            for (int i = 0; i < n; i++){
                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                    deque.pollLast();
                }
                deque.offerLast(i);
                if ((i - k + 1 >= 0) && !deque.isEmpty()){
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return result;
        }
    }
// @lc code=end
}

