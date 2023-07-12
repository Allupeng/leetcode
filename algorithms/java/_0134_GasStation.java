/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] Gas Station
 *
 * https://leetcode.cn/problems/gas-station/description/
 *
 * algorithms
 * Medium (51.15%)
 * Likes:    1295
 * Dislikes: 0
 * Total Accepted:    260.2K
 * Total Submissions: 508.7K
 * Testcase Example:  '[1,2,3,4,5]\n[3,4,5,1,2]'
 *
 * There are n gas stations along a circular route, where the amount of gas at
 * the i^th station is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from the i^th station to its next (i + 1)^th station. You begin the
 * journey with an empty tank at one of the gas stations.
 * 
 * Given two integer arrays gas and cost, return the starting gas station's
 * index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be
 * unique
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 +
 * 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back
 * to station 3.
 * Therefore, return 3 as the starting index.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to
 * the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 =
 * 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you
 * only have 3.
 * Therefore, you can't travel around the circuit once no matter where you
 * start.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == gas.length == cost.length
 * 1 <= n <= 10^5
 * 0 <= gas[i], cost[i] <= 10^4
 * 
 * 
 */

import org.junit.Test;

public class _0134_GasStation {
// @lc code=start
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas.length == 0){
                return -1;
            }
            if (gas.length == 1){
                if (gas[0] - cost[0] >= 0){
                    return 0;
                }
                return -1;
            }
            int leftGas = 0;
            int curGas = 0;
            int startIndex = 0;
            for (int i = 0; i < gas.length; i++){
                int netGas = gas[i] - cost[i];
                leftGas  += netGas;
                curGas += netGas;
                if (curGas < 0){
                    startIndex = i + 1;
                    curGas = 0;
                }
            }
            // leftGas大于0代表startIndex 之前
            return leftGas >= 0 ? startIndex : -1;
        }
    }
// @lc code=end

    @Test
    public void test(){
        int[] gas = new int[]{1,2,3,4,5}, cost = new int[]{3,4,5,1,2};
        Solution solution = new Solution();
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}

