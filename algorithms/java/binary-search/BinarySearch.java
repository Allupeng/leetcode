import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearch{
    /**
     * [low, high]
     * 左闭右闭区间 迭代法
     */
    public int binarySearchLeftClosedRightClosedIterative(int lo, int hi, int target, int[] nums){
        if (lo > hi) return -1;
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if(target < nums[mid]){
                hi = mid - 1;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * [low, high]
     * 左闭右闭区间 递归法
     */
    public int binarySearchLeftClosedRightClosedRecursive(int lo, int hi, int target, int[] nums){
        if (lo > hi) return -1;
        int mid = lo + ((hi - lo) >> 1);
        if (target < nums[mid]){
            return binarySearchLeftClosedRightClosedRecursive(lo, mid - 1, target, nums);
        }else if (nums[mid] < target){
            return binarySearchLeftClosedRightClosedRecursive(mid + 1, hi, target, nums);
        }else {
            return mid;
        }
    }

    /**
     * [low, high)
     * 左闭右开区间 迭代法 
     */
    public int binarySearchLeftClosedRightOpenIterative(int lo, int hi, int target, int[] nums){
        if(lo >= hi) return -1;
        while(lo < hi){
            int mid = lo + ((hi - lo) >> 1);
            if(target < nums[mid]){
                hi = mid;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * [low, high)
     * 左闭右开区间 递归法
     */
    public int binarySearchLeftClosedRightOpenRecursive(int lo, int hi, int target, int[] nums){
        // 边界条件改变
        if (lo >= hi) return -1;
        int mid = lo + ((hi - lo) >> 1);
        if (target < nums[mid]){
            return binarySearchLeftClosedRightOpenRecursive(lo, mid, target, nums);
        }else if(nums[mid] < target){
            return binarySearchLeftClosedRightOpenRecursive(mid + 1, hi, target, nums);
        }else {
            return mid;
        }
    }

    /**
     * 寻找第一个等于target的元素
     * 数组有序
     * 数组会出现重复元素
     * 左闭右闭区间 迭代法
     */
    public int findFirstElementByBinarySearch(int lo, int hi, int target, int[] nums){
        if(lo > hi) return -1;
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if(target < nums[mid]){
                hi = mid - 1;
            }else if (nums[mid] < target){
                lo = mid + 1;
            }else{
                // 如果到达左边界 或者 mid - 1的元素不等于 mid，直接返回
                if(mid == 0 || nums[mid - 1] != nums[mid]){
                    return mid;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 寻找最后一个等于target的元素
     * 数组有序
     * 数组会出现重复元素
     * 左闭右闭区间 迭代法
     */
    public int findLastElementByBinarySearch(int lo, int hi, int target, int[] nums){
        if(lo > hi) return -1;
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if (target < nums[mid]){
                hi = mid - 1;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                // 如果到达右边界 或者 mid + 1的元素不等于 mid 直接返回
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                    return mid;
                }else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于target的元素
     */
    public int findFirstElementGreaterEqualsThanTarget(int lo, int hi, int target, int[] nums){
        if(lo > hi) return -1;
        while (lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if(nums[mid] >= target){
                // 如果到达左边界或前一个元素小于 target
                if(mid == 0 || nums[mid - 1] < target){
                    return mid;
                }else {
                    hi = mid - 1;
                }
            }else if (nums[mid] < target){
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于target的元素
     */
    public int findLastElementLessEqualsThanTarget(int lo, int hi, int target, int[] nums){
        if(lo > hi) return -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if(nums[mid] <= target){
                if(mid == nums.length - 1 || nums[mid + 1] > target){
                    return mid;
                }else {
                    lo = mid + 1;
                }
            }else if (target < nums[mid]){
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int leftBound(int lo, int hi, int target, int[] nums){
        while(lo < hi){
            int mid = lo + ((hi - lo) >> 1);
            if(target == nums[mid]){
                hi = mid;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else if(target < nums[mid]){
                hi = mid;
            }
        }
        if(lo < 0 || lo >= nums.length) return -1;
        return nums[lo] == target ? lo : -1;
    }

    public int rightBound(int lo, int hi, int target, int[] nums){
        while(lo < hi){
            int mid = lo + ((hi - lo) >> 1);
            if(target == nums[mid]){
                lo = mid + 1;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else if(target < nums[mid]){
                hi = mid;
            }
        }
        if(lo - 1 < 0 || lo - 1 >= nums.length) return -1;
        return nums[lo - 1] == target ? lo - 1 : -1;
    }

    @Test
    public void testBinarySearchLeftClosedRightClosedIterative() {
        int[] nums = {1, 3, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(2, bs.binarySearchLeftClosedRightClosedIterative(0, nums.length - 1, 5, nums));
        assertEquals(4, bs.binarySearchLeftClosedRightClosedIterative(0, nums.length - 1, 9, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightClosedIterative(0, nums.length - 1, 2, nums));
    }
    
    @Test
    public void testBinarySearchLeftClosedRightClosedRecursive() {
        int[] nums = {1, 3, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(2, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 5, nums));
        assertEquals(4, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 9, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 2, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 10, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 0, nums));
        assertEquals(0, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 1, nums));
        assertEquals(3, bs.binarySearchLeftClosedRightClosedRecursive(0, nums.length - 1, 7, nums));
    }

    @Test
    public void testBinarySearchLeftClosedRightOpenIterative() {
        int[] nums = {1, 3, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(2, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 5, nums));
        assertEquals(4, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 9, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 2, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 10, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 0, nums));
        assertEquals(0, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 1, nums));
        assertEquals(3, bs.binarySearchLeftClosedRightOpenIterative(0, nums.length, 7, nums));
    }

    @Test
    public void testBinarySearchLeftClosedRightOpenRecursive() {
        int[] nums = {1, 3, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(2, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 5, nums));
        assertEquals(4, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 9, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 2, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 10, nums));
        assertEquals(-1, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 0, nums));
        assertEquals(0, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 1, nums));
        assertEquals(3, bs.binarySearchLeftClosedRightOpenRecursive(0, nums.length, 7, nums));
    }

    @Test
    public void testFindFirstElementByBinarySearch() {
        int[] nums = {1, 3, 5, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(2, bs.findFirstElementByBinarySearch(0, nums.length - 1, 5, nums));
        assertEquals(4, bs.findFirstElementByBinarySearch(0, nums.length - 1, 7, nums));
        assertEquals(-1, bs.findFirstElementByBinarySearch(0, nums.length - 1, 2, nums));
        assertEquals(-1, bs.findFirstElementByBinarySearch(0, nums.length - 1, 10, nums));
        assertEquals(-1, bs.findFirstElementByBinarySearch(0, nums.length - 1, 0, nums));
        assertEquals(0, bs.findFirstElementByBinarySearch(0, nums.length - 1, 1, nums));
        assertEquals(5, bs.findFirstElementByBinarySearch(0, nums.length - 1, 9, nums));
    }

    @Test
    public void testFindLastElementByBinarySearch() {
        int[] nums = {1, 3, 5, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(3, bs.findLastElementByBinarySearch(0, nums.length - 1, 5, nums));
        assertEquals(4, bs.findLastElementByBinarySearch(0, nums.length - 1, 7, nums));
        assertEquals(-1, bs.findLastElementByBinarySearch(0, nums.length - 1, 2, nums));
        assertEquals(-1, bs.findLastElementByBinarySearch(0, nums.length - 1, 10, nums));
        assertEquals(-1, bs.findLastElementByBinarySearch(0, nums.length - 1, 0, nums));
        assertEquals(0, bs.findLastElementByBinarySearch(0, nums.length - 1, 1, nums));
        assertEquals(5, bs.findLastElementByBinarySearch(0, nums.length - 1, 9, nums));
    }

    @Test
    public void testfindFirstElementGreaterEqualsThanTarget() {
        int[] nums = {1, 3, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(2, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 4, nums));
        assertEquals(3, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 6, nums));
        assertEquals(0, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 0, nums));
        assertEquals(0, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 1, nums));
        assertEquals(-1, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 10, nums));
        assertEquals(4, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 9, nums));
        assertEquals(4, bs.findFirstElementGreaterEqualsThanTarget(0, nums.length - 1, 8, nums));
    }

    @Test
    public void testFindLastElementLessEqualsThanTarget() {
        int[] nums = {1, 3, 5, 5, 7, 9};
        BinarySearch bs = new BinarySearch();
        assertEquals(3, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 5, nums));
        assertEquals(4, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 7, nums));
        assertEquals(5, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 9, nums));
        assertEquals(0, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 1, nums));
        assertEquals(-1, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 0, nums));
        assertEquals(5, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 10, nums));
        assertEquals(4, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 5, new int[]{5, 5, 5, 5, 5}));
        assertEquals(4, bs.findLastElementLessEqualsThanTarget(0, nums.length - 1, 6, new int[]{5, 5, 5, 5, 5}));
    }
}