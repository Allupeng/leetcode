package hot100;

public class _0283_MoveZeroes {
// @lc code=start
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0, right = 0;
            while (right < nums.length){
                if (nums[right] != 0){
                    if (left != right){
                        swap(nums, left, right);
                    }
                    left++;
                }
                right++;
            }
        }

        private void swap(int[] nums, int i, int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
// @lc code=end
}

