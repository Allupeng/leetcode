/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] Remove Element
 *
 * https://leetcode.cn/problems/remove-element/description/
 *
 * algorithms
 * Easy (59.20%)
 * Likes:    1807
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.8M
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Given an integer array nums and an integer val, remove all occurrences of
 * val in nums in-place. The order of the elements may be changed. Then return
 * the number of elements in nums which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to
 * get accepted, you need to do the following things:
 * 
 * 
 * Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val. The remaining elements of nums are not
 * important as well as the size of nums.
 * Return k.
 * 
 * 
 * Custom Judge:
 * 
 * The judge will test your solution with the following code:
 * 
 * 
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * ⁠                           // It is sorted with no values equaling val.
 * 
 * int k = removeElement(nums, val); // Calls your implementation
 * 
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
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
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * 
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _0027_RemoveElement{
// @lc code=start
    class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            for(int right = 0; right < nums.length; right++){
                if(nums[right] != val){
                    nums[left] = nums[right];
                    left++;
                }
            }
            return left;
        }
    }
// @lc code=end
    @Test
    public void testRemoveElement() {
        Solution solution = new Solution();

        // Test case 1: Remove a single element
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int expected1 = 2;
        int result1 = solution.removeElement(nums1, val1);
        assertEquals(expected1, result1);

        // Test case 2: Remove multiple elements
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int expected2 = 5;
        int result2 = solution.removeElement(nums2, val2);
        assertEquals(expected2, result2);

        // Test case 3: Remove all elements
        int[] nums3 = {1, 1, 1, 1, 1};
        int val3 = 1;
        int expected3 = 0;
        int result3 = solution.removeElement(nums3, val3);
        assertEquals(expected3, result3);

        // Test case 4: Remove no elements
        int[] nums4 = {1, 2, 3, 4, 5};
        int val4 = 6;
        int expected4 = 5;
        int result4 = solution.removeElement(nums4, val4);
        assertEquals(expected4, result4);
    }
}

