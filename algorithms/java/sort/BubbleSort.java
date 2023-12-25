package sort;

import org.junit.Test;

/**
 * @author Allu.Peng
 * 2023/11/13 15:04:05
 **/
public class BubbleSort {

    public void sort(int[] nums){
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
        int[] nums = new int[]{4, 7, 3, 1, 0, 9, 8};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
    }
}
