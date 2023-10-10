/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] Third Maximum Number
 *
 * https://leetcode.cn/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (39.80%)
 * Likes:    443
 * Dislikes: 0
 * Total Accepted:    150.8K
 * Total Submissions: 379K
 * Testcase Example:  '[3,2,1]'
 *
 * Given an integer array nums, return the third distinct maximum number in
 * this array. If the third maximum does not exist, return the maximum
 * number.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned
 * instead.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they
 * have the same value).
 * The third distinct maximum is 1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Can you find an O(n) solution?
 */

import org.junit.Assert;
import org.junit.Test;

public class _0414_ThirdMaximumNumber {
// @lc code=start
    class Solution {
        public int thirdMax(int[] nums) {
            long firstNum = Long.MIN_VALUE, secondNum = Long.MIN_VALUE, thirdNum = Long.MIN_VALUE;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > firstNum){
                    thirdNum = secondNum;
                    secondNum = firstNum;
                    firstNum = nums[i];
                }else if (nums[i] > secondNum && nums[i] < firstNum){
                    thirdNum = secondNum;
                    secondNum = nums[i];
                }else if (nums[i] > thirdNum && nums[i] < secondNum){
                    thirdNum = nums[i];
                }
            }
            // 如果第三大的不存在，返回最大的
            return thirdNum != Long.MIN_VALUE ?
                    (int) thirdNum : (int) firstNum;
        }
    }
// @lc code=end
    @Test
    public void test(){
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.thirdMax(new int[]{2, 2, 3, 1}));
    }
}

