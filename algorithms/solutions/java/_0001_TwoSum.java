package hot100;

import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum {
// @lc code=start
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int another = target - nums[i];
                if (map.containKey(another)){
                    return new int[]{map.get(another), i};
                }
                map.put(nums[i, i]);
            }
            return new int[]{-1, -1};
        }
    }
// @lc code=end
}
