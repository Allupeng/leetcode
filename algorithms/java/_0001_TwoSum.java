import java.util.HashMap;
import java.util.Map;

public class _0001_TwoSum {
    /**
     * find two value sum = target
     * if find
     * return two nums index
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                int another = target - nums[i];
                if (numMap.get(another) != null){
                    return new int[]{numMap.get(another), i};
                }
                numMap.put(nums[i], i);
            }
            return new int[]{-1, -1};
        }
    }
}