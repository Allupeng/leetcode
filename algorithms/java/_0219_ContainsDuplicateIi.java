/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.cn/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (44.79%)
 * Likes:    643
 * Dislikes: 0
 * Total Accepted:    252.6K
 * Total Submissions: 564.1K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _0219_ContainsDuplicateIi {
// @lc code=start
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if (map.containsKey(nums[i])){
                    if (Math.abs(map.get(nums[i]) - i) <= k){
                        return true;
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }
}

