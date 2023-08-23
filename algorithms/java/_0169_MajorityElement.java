/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.cn/problems/majority-element/description/
 *
 * algorithms
 * Easy (66.79%)
 * Likes:    1917
 * Dislikes: 0
 * Total Accepted:    737.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 * 
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import org.junit.Assert;
import org.junit.Test;

public class _0169_MajorityElement {
// @lc code=start
    class Solution {
        public int majorityElement(int[] nums) {
            // 摩尔计数法
            int cnt = 1;
            int maxElement = nums[0];
            for (int i = 1; i < nums.length; i++){
                if (nums[i] != maxElement){
                    cnt--;
                    if (cnt == 0){
                        maxElement = nums[i];
                        cnt = 1;
                    }
                }else {
                    cnt++;
                }
            }
            return maxElement;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{2,2,1,1,1,2,2};
        Assert.assertEquals(2, solution.majorityElement(nums1));

        int[] nums2 = new int[]{3,2,3};
        Assert.assertEquals(3, solution.majorityElement(nums2));
    }

}

