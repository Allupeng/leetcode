/*
 * @lc app=leetcode.cn id=2605 lang=java
 *
 * [2605] Form Smallest Number From Two Digit Arrays
 *
 * https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/description/
 *
 * algorithms
 * Easy (62.44%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    26.3K
 * Total Submissions: 38.6K
 * Testcase Example:  '[4,1,3]\n[5,7]'
 *
 * Given two arrays of unique digits nums1 and nums2, return the smallest
 * number that contains at least one digit from each array.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [4,1,3], nums2 = [5,7]
 * Output: 15
 * Explanation: The number 15 contains the digit 1 from nums1 and the digit 5
 * from nums2. It can be proven that 15 is the smallest number we can have.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
 * Output: 3
 * Explanation: The number 3 contains the digit 3 which exists in both
 * arrays.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * All digits in each array are unique.
 * 
 * 
 */

import java.util.Arrays;

public class _2605_FormSmallestNumberFromTwoDigitArrays {
// @lc code=start
    class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
            int[] t1 = new int[10];
            int[] t2 = new int[10];
            Arrays.fill(t1, 0);
            Arrays.fill(t2, 0);
            for (int i : nums1) {
                t1[i] = 1;
            }
            for (int i : nums2) {
                t2[i] = 1;
            }
            int min1 = -1, min2 = -1;
            for (int i = 1; i < 10; i++){
                if (t1[i] != 0 && t2[i] != 0){
                    return i;
                }
                if (t1[i] != 0 && min1 == -1){
                    min1 = i;
                }
                if (t2[i] != 0 && min2 == -1){
                    min2 = i;
                }
            }
            return min1 < min2 ? min1 * 10 + min2 : min2 * 10 + min1;
        }
    }
// @lc code=end
}

