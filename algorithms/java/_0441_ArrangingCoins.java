/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] Arranging Coins
 *
 * https://leetcode.cn/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (45.16%)
 * Likes:    284
 * Dislikes: 0
 * Total Accepted:    125.3K
 * Total Submissions: 277.5K
 * Testcase Example:  '5'
 *
 * You have n coins and you want to build a staircase with these coins. The
 * staircase consists of k rows where the i^th row has exactly i coins. The
 * last row of the staircase may be incomplete.
 * 
 * Given the integer n, return the number of complete rows of the staircase you
 * will build.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3^rd row is incomplete, we return 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4^th row is incomplete, we return 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

public class _0441_ArrangingCoins {
// @lc code=start
    class Solution {
        public int arrangeCoins(int n) {
            int completedStairsCount = 0;
            int k = 1;
            while (n - k >= 0){
                n -= k;
                completedStairsCount++;
                k++;
            }
            return completedStairsCount;
        }
    }
// @lc code=end
}

