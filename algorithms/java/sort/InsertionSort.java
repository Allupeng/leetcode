package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Allu.Peng
 * 插入排序
 * 2023/08/14 19:08:06
 **/
public class InsertionSort {

    private void sort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int key = nums[i];
            int j = i - 1;
               /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
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
