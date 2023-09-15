/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (54.00%)
 * Likes:    1810
 * Dislikes: 0
 * Total Accepted:    443.6K
 * Total Submissions: 821.7K
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

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class _0128_LongestConsecutiveSequence {
// @lc code=start
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0){
                return 0;
            }
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int max = 1;
            for (int num : nums){
                if (!set.contains(num - 1)){
                    int len = 1;
                    int next = num + 1;
                    while (set.contains(next)){
                        next = next + 1;
                        len++;
                    }
                    max = Math.max(max, len);
                }
            }
            return max;
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.longestConsecutive(nums));
    }
}

