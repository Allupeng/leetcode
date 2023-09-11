/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.cn/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (52.81%)
 * Likes:    2124
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in
 * nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead
 * be stored inside the array nums1. To accommodate this, nums1 has a length of
 * m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a
 * length of n.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there
 * to ensure the merge result can fit in nums1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 * 
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _0088_MergeSortedArray {
// @lc code=start
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] num1Copy = Arrays.copyOf(nums1, m);
            int i = 0, j = 0, k = 0;
            while (i < m && j < n){
                if (num1Copy[i] <= nums2[j]){
                    nums1[k++] = num1Copy[i];
                    i++;
                }else {
                    nums1[k++] = nums2[j];
                    j++;
                }
            }
            while (i < m){
                nums1[k++] = num1Copy[i++];
            }
            while (j < n){
                nums1[k++] = nums2[j++];
            }
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[] nums1 = new int[]{1, 2, 3, 0 , 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 4 , 5};
        int m = 3;
        int n = 4;
        Solution solution = new Solution();
        solution.merge(nums1, m , nums2, n);
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}

