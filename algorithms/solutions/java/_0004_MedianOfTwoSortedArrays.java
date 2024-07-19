/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (42.18%)
 * Likes:    7094
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

import java.util.Arrays;

public class _0004_MedianOfTwoSortedArrays {
// @lc code=start
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // ensure X is smaller one
            if (nums1.length > nums2.length){
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }
            int X = nums1.length, Y = nums2.length;
            boolean isOdd = (X + Y) % 2 == 1;
            int start = 0, end = X;
            while (start <= end){
                int partitionX = (start + end) / 2;
                int partitionY = (X + Y + 1) / 2 - partitionX;
                int leftPartMaxX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
                int leftPartMaxY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
                int rightPartMinX = partitionX == X ? Integer.MAX_VALUE : nums1[partitionX];
                int rightPartMinY = partitionY == Y ? Integer.MAX_VALUE : nums2[partitionY];
                if (leftPartMaxX <= rightPartMinY && leftPartMaxY <= rightPartMinX){
                    if (isOdd){
                        return Math.max(leftPartMaxX, leftPartMaxY);
                    }else{
                        return (Math.max(leftPartMaxX, leftPartMaxY) + Math.min(rightPartMinX, rightPartMinY)) / 2.0;
                    }
                }else if (leftPartMaxX > rightPartMinY){
                    end = partitionX - 1;
                }else{
                    start = partitionX + 1;
                }
            }
            return -1;
        }
    }
// @lc code=end
}

