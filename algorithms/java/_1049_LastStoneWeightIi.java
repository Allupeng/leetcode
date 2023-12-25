/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 *
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 *
 * algorithms
 * Medium (69.29%)
 * Likes:    716
 * Dislikes: 0
 * Total Accepted:    132.7K
 * Total Submissions: 191.5K
 * Testcase Example:  '[2,7,4,1,8,1]'
 *
 * You are given an array of integers stones where stones[i] is the weight of
 * the i^th stone.
 * 
 * We are playing a game with the stones. On each turn, we choose any two
 * stones and smash them together. Suppose the stones have weights x and y with
 * x <= y. The result of this smash is:
 * 
 * 
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has
 * new weight y - x.
 * 
 * 
 * At the end of the game, there is at most one stone left.
 * 
 * Return the smallest possible weight of the left stone. If there are no
 * stones left, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0, so the array converts to [1], then that's
 * the optimal value.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: stones = [31,26,33,21,40]
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _1049_LastStoneWeightIi {
// @lc code=start
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = Arrays.stream(stones).sum();
            int target = sum / 2;
            // dp[i][j] 代表0...i的的石头在j容量下最大重量
            int[][] dp = new int[stones.length][target + 1];
            // 初始化
            for (int j = 0; j <= target; j++){
                if (stones[0] <= j){
                    dp[0][j] = stones[0];
                }
            }
            for (int i = 0; i < stones.length; i++){
                dp[i][0] = 0;
            }
            for (int i = 1; i < stones.length; i++){
                for (int j = 1; j <= target; j++){
                    if (j < stones[i]){
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                    }
                }
            }
            return sum - 2 * dp[stones.length - 1][target];
        }
    }
// @lc code=end

    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] stones = new int[]{2,7,4,1,8,1};
        Assert.assertEquals(1, solution.lastStoneWeightII(stones));
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] stones = new int[]{31,26,33,21,40};
        Assert.assertEquals(5, solution.lastStoneWeightII(stones));
    }


}

