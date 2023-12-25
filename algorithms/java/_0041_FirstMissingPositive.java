/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] First Missing Positive
 *
 * https://leetcode.cn/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (43.36%)
 * Likes:    1932
 * Dislikes: 0
 * Total Accepted:    318.6K
 * Total Submissions: 734.7K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array nums, return the smallest missing positive
 * integer.
 * 
 * You must implement an algorithm that runs in O(n) time and uses O(1)
 * auxiliary space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class _0041_FirstMissingPositive {
 // @lc code=start
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 将每个元素放置正确的位置。
            // nums[i] 放置为 nums[nums[i] - 1]，例如 2 放置 nums[1]
            // 要注意边界问题
            for (int i = 0; i < nums.length; i++){
                while (nums[i] > 0 && nums[i] < nums.length && (nums[i] != nums[nums[i] - 1])){
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < nums.length; i++){
                if (nums[i] != i + 1){
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        private void swap(int[] nums, int i, int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
// @lc code=end

    /**
     * O(n) space
     */
    private int firstMissingPositiveByHashSet(int[] nums) {
        Set<Integer> mySet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; i++){
            if (!mySet.contains(i + 1)){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1, 1};
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.firstMissingPositive(nums));
    }
}

