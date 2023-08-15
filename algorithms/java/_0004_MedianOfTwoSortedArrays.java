/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.56%)
 * Likes:    6699
 * Dislikes: 0
 * Total Accepted:    988.8K
 * Total Submissions: 2.4M
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

import org.junit.Assert;
import org.junit.Test;

public class _0004_MedianOfTwoSortedArrays {
// @lc code=start
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0){
                return 0.0d;
            }
            int m = nums1.length;
            int n = nums2.length;
            double[] arr = new double[m + n];
            int i = 0, j = 0;
            int k = 0;
            while(i < m && j < n){
                if (nums1[i] <= nums2[j]){
                    arr[k] = nums1[i];
                    i++;
                }else {
                    arr[k] = nums2[j];
                    j++;
                }
                k++;
            }
            while(i < m){
                arr[k] = nums1[i];
                k++;
                i++;
            }
            while(j < n){
                arr[k] = nums2[j];
                k++;
                j++;
            }
            if (arr.length % 2 == 1){
                return arr[arr.length / 2];
            }else {
                return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
            }
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}

