/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.cn/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (74.28%)
 * Likes:    775
 * Dislikes: 0
 * Total Accepted:    446.2K
 * Total Submissions: 600.8K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and you may return
 * the result in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class _0349_IntersectionOfTwoArrays {
// @lc code=start
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            // 0 <= nums[i] <= 1000
            byte[] hash = new byte[1001];
            for (int k : nums1) {
                hash[k] = 1;
            }
            for (int j : nums2) {
                if (hash[j] == 1) {
                    set.add(j);
                }
            }
            return set.stream().mapToInt(x -> x).toArray();
        }
    }
// @lc code=end
}

