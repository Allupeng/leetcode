/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] Next Greater Element I
 *
 * https://leetcode.cn/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (71.81%)
 * Likes:    1061
 * Dislikes: 0
 * Total Accepted:    273.5K
 * Total Submissions: 380.9K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * The next greater element of some element x in an array is the first greater
 * element that is to the right of x in the same array.
 * 
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where
 * nums1 is a subset of nums2.
 * 
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] ==
 * nums2[j] and determine the next greater element of nums2[j] in nums2. If
 * there is no next greater element, then the answer for this query is -1.
 * 
 * Return an array ans of length nums1.length such that ans[i] is the next
 * greater element as described above.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
 * the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so
 * the answer is -1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so
 * the answer is -1.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 10^4
 * All integers in nums1 and nums2 are unique.
 * All the integers of nums1 also appear in nums2.
 * 
 * 
 * 
 * Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _0496_NextGreaterElementI {
// @lc code=start
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] result = new int[nums1.length];
            // 该map key为num2[j] , value为下一个比nums2[j]更大的元素的索引
            Map<Integer, Integer> numsMappingsNextElement = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < nums2.length; j++){
                while(!stack.isEmpty() && nums2[j] > nums2[stack.peek()]){
                    int prev = stack.pop();
                    numsMappingsNextElement.put(nums2[prev], nums2[j]);
                }
                stack.push(j);
            }
            for (int i = 0; i < nums1.length; i++){
                Integer nextElementIndex = numsMappingsNextElement.get(nums1[i]);
                result[i] = nextElementIndex == null ? -1 : nextElementIndex;
            }
            return result;
        }
    }
// @lc code=end
    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] expected1 = new int[]{-1, 3, -1};
        Assert.assertArrayEquals(expected1, solution.nextGreaterElement(nums1, nums2));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1 , 2, 3, 4};
        int[] expected1 = new int[]{3, -1};
        Assert.assertArrayEquals(expected1, solution.nextGreaterElement(nums1, nums2));
    }

    @Test
    public void test3(){
        Solution solution = new Solution();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1 , 2, 3, 4};
        int[] expected1 = new int[]{-1, 2, 3};
        Assert.assertArrayEquals(expected1, solution.nextGreaterElement(nums1, nums2));
    }

}
