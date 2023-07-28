/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 *
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 *
 * algorithms
 * Easy (64.84%)
 * Likes:    1274
 * Dislikes: 0
 * Total Accepted:    328.7K
 * Total Submissions: 506.9K
 * Testcase Example:  '[10,15,20]'
 *
 * You are given an integer array cost where cost[i] is the cost of i^th step
 * on a staircase. Once you pay the cost, you can either climb one or two
 * steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * 
 * Return the minimum cost to reach the top of the floor.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * 
 * 
 */

import org.junit.Test;

public class _0746_MinCostClimbingStairs {
// @lc code=start
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            // dp[i] 存储的是到达第i个index时的最小花费
            if (cost.length == 1){
                return cost[0];
            }
            if (cost.length == 2){
                return Math.min(cost[0], cost[1]);
            }
            int[] dp = new int[cost.length + 1];
            // you can start from index 0 or index 1
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= cost.length; i++){
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]) ;
            }
            return dp[cost.length];
        }
    }
// @lc code=end
    @Test
    public void test(){
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        Solution solution = new Solution();
        assert 6 == solution.minCostClimbingStairs(cost);
    }
}

