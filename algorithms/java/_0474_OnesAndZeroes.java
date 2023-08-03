/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] Ones and Zeroes
 *
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (65.30%)
 * Likes:    1010
 * Dislikes: 0
 * Total Accepted:    167.7K
 * Total Submissions: 256.8K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * You are given an array of binary strings strs and two integers m and n.
 * 
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of
 * y.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10",
 * "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the
 * maximum of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0474_OnesAndZeroes {
// @lc code=start
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            // 定义dp[i][j] 为恰好为i个'0'字符和j个'1'字符时的子集数量
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (String s : strs){
                int sZeroNumbers = getZeroNumbers(s);
                int sOneNumbers = getOneNumbers(s);
               for (int i = m; i >= sZeroNumbers; i--){
                   for (int j = n; j >= sOneNumbers; j--){
                       dp[i][j] = Math.max(dp[i][j], dp[i - sZeroNumbers][j - sOneNumbers] + 1);
                   }
               }
            }
            return dp[m][n];
        }

        private int getZeroNumbers(String s){
            int times = 0;
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch == '0'){
                    times++;
                }
            }
            return times;
        }

        private int getOneNumbers(String s){
            int times = 0;
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch == '1'){
                    times++;
                }
            }
            return times;
        }
    }
// @lc code=end

    @Test
    public void test1(){
        String[] strs = new String[]{"10","0","1"};
        int m = 1, n = 1;
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findMaxForm(strs, m, n));
    }

    @Test
    public void test2(){
        String[] strs = new String[]{"10","0001","111001","1","0"};
        int m = 5, n = 3;
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.findMaxForm(strs, m, n));
    }
}

