/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (63.64%)
 * Likes:    2250
 * Dislikes: 0
 * Total Accepted:    903.2K
 * Total Submissions: 1.4M
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

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0215_KthLargestElementInAnArray {
// @lc code=start
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // k - 1是因为数组从0 开始
            return findKth(nums, k - 1, 0, nums.length - 1);
        }

        private int findKth(int[] nums, int k, int l, int h){
            int p = partition(nums, l, h);
            if (p == k){
                return nums[p];
            }else if (p < k){
                return findKth(nums, k, p + 1, h);
            }else {
                return findKth(nums, k, l, p - 1);
            }
        }

        private int partition(int[] nums, int l, int h){
            int pivot = nums[h];
            int i = l - 1;
            for (int j = l; j <= h - 1; j++){
                if (nums[j] > pivot){
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, h);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{3,2,1,5,6,4};
        int k1 = 2;
        Assert.assertEquals(5, solution.findKthLargest(nums1, k1));

        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        int k2 = 4;
        Assert.assertEquals(4, solution.findKthLargest(nums2, k2));
    }
}

