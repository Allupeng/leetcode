package sort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort{

    /**
     * 冒泡排序
     * @param nums 数组
     */
    private void sort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] > nums[j]){
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    public void test(){
        int[] nums1 = new int[]{64, 25, 12, 22, 11};
        sort(nums1);
        Assert.assertArrayEquals(new int[]{11, 12, 22, 25, 64}, nums1);

        int[] nums2 = new int[]{1, 2, 3, 4, 11};
        sort(nums2);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 11}, nums2);

    }
}
