/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (54.75%)
 * Likes:    3177
 * Dislikes: 0
 * Total Accepted:    1.5M
 * Total Submissions: 2.7M
 * Testcase Example:  '[1,1,2]'
 *
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. Then return the
 * number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you
 * need to do the following things:
 * 
 * 
 * Change the array nums such that the first k elements of nums contain the
 * unique elements in the order they were present in nums initially. The
 * remaining elements of nums are not important as well as the size of
 * nums.
 * Return k.
 * 
 * 
 * Custom Judge:
 * 
 * The judge will test your solution with the following code:
 * 
 * 
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * 
 * int k = removeDuplicates(nums); // Calls your implementation
 * 
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * ⁠   assert nums[i] == expectedNums[i];
 * }
 * 
 * 
 * If all assertions pass, then your solution will be accepted.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 * 
 * 
 */

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class _0026_RemoveDuplicatesFromSortedArray{
// @lc code=start
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            int leftPointer = 0;
            int rightPointer = 0;
            Set<Integer> elements = new HashSet<>();
            while(rightPointer < nums.length){
                int element = nums[rightPointer];
                if(!elements.contains(element)){
                    nums[leftPointer] = nums[rightPointer];
                    elements.add(element);
                    leftPointer++;
                }
                rightPointer++;
            }   
            return leftPointer;
        }
    }
// @lc code=end
    @Test
    public void testRemoveDuplicates() {
        Solution solution = new Solution();

        // Test case 1: Empty array
        int[] nums1 = {};
        int result1 = solution.removeDuplicates(nums1);
        assertEquals(0, result1);

        // Test case 2: Array with no duplicates
        int[] nums2 = {1, 2, 3, 4, 5};
        int result2 = solution.removeDuplicates(nums2);
        assertEquals(5, result2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums2);

        // Test case 3: Array with duplicates
        int[] nums3 = {1, 2, 2, 3, 3, 3, 4, 5, 5};
        int result3 = solution.removeDuplicates(nums3);
        assertEquals(5, result3);
    }
}

