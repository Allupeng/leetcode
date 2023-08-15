package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Allu.Peng
 * 快速排序
 * 2023/08/15 14:55:06
 **/
public class QuickSort {

    private void sort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r){
        if (l < r){
            int pivot = partition(nums, l, r);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
    }

    private int partition(int[] nums, int l, int h){
        int pivot = nums[h];
        // i 用来追踪小于pivot的元素位置
        int i = l - 1;
        // 每次迭代时，如果当前元素比pivot小，那么当前元素和i进行交换
        for (int j = l; j <= h - 1; j++){
            if (nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        //当迭代完成时，i + 1和pivot的元素进行交换。最终使得pivot左边的元素都比他小，右边的元素都比他大
        swap(nums, i + 1, h);
        return i + 1;
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

        int[] nums2 = new int[]{1, 12, 2, 11, 5};
        sort(nums2);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 11}, nums2);
    }
}
