package hot100;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class _0128_LongestConsecutiveSequence {
// @lc code=start
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int maxLen = 1;
            for(int num : nums){
                if (!set.contains(num - 1)){
                    int curNum = num;
                    int curLen = 1;
                    while(set.contains(curNum + 1)){
                        curNum++;
                        curLen++;
                    }
                    maxLen = Math.max(maxLen, curLen);
                }
            }
            return maxLen;
        }
    }
// @lc code=end
}

