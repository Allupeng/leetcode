/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] Counting Bits
 *
 * https://leetcode.cn/problems/counting-bits/description/
 *
 * algorithms
 * Easy (78.64%)
 * Likes:    1250
 * Dislikes: 0
 * Total Accepted:    307.6K
 * Total Submissions: 391.2K
 * Testcase Example:  '2'
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of
 * i.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 10^5
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * It is very easy to come up with a solution with a runtime of O(n log n). Can
 * you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like
 * __builtin_popcount in C++)?
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0338_CountingBits {
// @lc code=start
    class Solution {
        public int[] countBits(int n) {
            if (n == 0){
                return new int[]{0};
            }
            int[] bits = new int[n + 1];
            // 0 1 10 11 100 101 110 111
            // 0 1 1 2   1   2  2  3
            for(int i = 1; i <= n; i++){
                // bits[i >> 1] 算出除最后一位其余位数 = 1的个数
                bits[i] = bits[i >> 1] + (i & 1);
            }
            return bits;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        Assert.assertArrayEquals(new int[]{0, 1, 1}, solution.countBits(2));
        Assert.assertArrayEquals(new int[]{0,1,1,2,1,2}, solution.countBits(5));
    }
}

