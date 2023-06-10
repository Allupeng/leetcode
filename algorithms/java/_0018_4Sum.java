/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.cn/problems/4sum/description/
 *
 * algorithms
 * Medium (36.88%)
 * Likes:    1606
 * Dislikes: 0
 * Total Accepted:    460K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0018_4Sum {
// @lc code=start
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Set<List<Integer>> result = new HashSet<>();
            Arrays.sort(nums);
            int n = nums.length;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    long sum = nums[i] + nums[j];
                    int left = j + 1;
                    int right = n - 1;
                    while(left < right){
                        long total = sum + nums[left] + nums[right];
                        if(total < target){
                            left++;
                        }else if (total > target){
                            right--;
                        }else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            right--;
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }
// @lc code=end
}

