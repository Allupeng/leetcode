import org.junit.Test;
import static org.junit.Assert.*;
public class _0704_BinarySearch {
    // if target in [left , right]
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (target == nums[mid]){
                    return mid;
                }else if(target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

   // if target in [left, right)

   /*
   class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right){
                int mid = (left + right) / 2;
                if (target < nums[mid]){
                    right = mid;
                }else if (target > nums[mid]){
                    left = mid + 1;
                }else{
                    return mid;
                }
            }
            return -1;
        }
    }
     */

    @Test
    public void test1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        _0704_BinarySearch.Solution solution = new _0704_BinarySearch().new Solution();
        int expected = 4;
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        int[] nums = {-2,-1,0,3,5,9,12};
        int target = 2;
        _0704_BinarySearch.Solution solution = new _0704_BinarySearch().new Solution();
        int expected = -1;
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }
}