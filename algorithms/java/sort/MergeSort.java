package sort;

import org.junit.Test;

/**
 * @author Allu.Peng
 * 2023/11/13 17:43:12
 **/
public class MergeSort {

    public void sort(int[] nums){
        if (nums.length < 2){
            return;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, nums.length - mid);

        sort(left);
        sort(right);

        conquer(nums, left, right);
    }

    private void conquer(int[] nums, int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                nums[k++] = left[i++];
            }else {
                nums[k++] = right[j++];
            }
        }
        while (i < left.length){
            nums[k++] = left[i++];
        }
        while (j < right.length){
            nums[k++] = right[j++];
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{4, 7, 3, 1, 0, 9, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        SortMethods.print(nums);
    }
}
