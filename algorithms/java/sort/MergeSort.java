package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Allu.Peng
 * 归并排序
 * 2023/08/14 19:52:07
 **/
public class MergeSort {
    /**
     * 分为两个数组进行排序
     * [l, m]
     * [m + 1, r]
     */
    private void sort(int[] nums, int l, int r){
        if (l < r){
            int m = l + (r - l) / 2;

            // sort first array & second array
            sort(nums, l, m);
            sort(nums, m + 1, r);

            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r){
        // first array is nums[l,m]
        // second array is nums[m + 1, r]
        int[] LArray = new int[m - l + 1];
        int[] RArray = new int[r - m];
        //copy array to LArray
        for (int i = 0; i < LArray.length; i++){
            LArray[i] = nums[l + i];
        }
        //copy array to RArray
        for (int j = 0; j < RArray.length; j++){
            RArray[j] = nums[m + j + 1];
        }
        //initial status
        int i = 0, j = 0;
        int k = l;
        while(i < LArray.length && j < RArray.length){
            if (LArray[i] <= RArray[j]){
                nums[k] = LArray[i];
                i++;
            }else {
                nums[k] = RArray[j];
                j++;
            }
            k++;
        }

        //copy 未完成的数组
        while(i < LArray.length){
            nums[k] = LArray[i];
            k++;
            i++;
        }

        //copy 未完成的数组
        while(j < RArray.length){
            nums[k] = RArray[j];
            k++;
            j++;
        }
    }

    @Test
    public void test(){
        int[] nums1 = new int[]{64, 25, 12, 22, 11};
        sort(nums1, 0, nums1.length - 1);
        Assert.assertArrayEquals(new int[]{11, 12, 22, 25, 64}, nums1);

        int[] nums2 = new int[]{1, 2, 3, 4, 11};
        sort(nums2, 0, nums2.length - 1);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 11}, nums2);
    }
}
