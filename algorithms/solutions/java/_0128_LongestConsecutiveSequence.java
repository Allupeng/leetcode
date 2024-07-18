 /*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (51.83%)
 * Likes:    2070
 * Dislikes: 0
 * Total Accepted:    624.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class _0128_LongestConsecutiveSequence {
// @lc code=start
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            int maxLen = 1;
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            for(int num : nums){
                if (!set.contains(num - 1)){
                    int curLen = 1;
                    int curNum = num;
                    while(set.contains(curNum + 1)){
                        curNum = curNum + 1;
                        curLen = curLen + 1;
                    }
                    maxLen = Math.max(curLen, maxLen);
                }
            }
            return maxLen;
        }
    }
// @lc code=end
}

