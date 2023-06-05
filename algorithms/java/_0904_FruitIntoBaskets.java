/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] Fruit Into Baskets
 *
 * https://leetcode.cn/problems/fruit-into-baskets/description/
 *
 * algorithms
 * Medium (44.90%)
 * Likes:    501
 * Dislikes: 0
 * Total Accepted:    128.6K
 * Total Submissions: 286.4K
 * Testcase Example:  '[1,2,1]'
 *
 * You are visiting a farm that has a single row of fruit trees arranged from
 * left to right. The trees are represented by an integer array fruits where
 * fruits[i] is the type of fruit the i^th tree produces.
 * 
 * You want to collect as much fruit as possible. However, the owner has some
 * strict rules that you must follow:
 * 
 * 
 * You only have two baskets, and each basket can only hold a single type of
 * fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from
 * every tree (including the start tree) while moving to the right. The picked
 * fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must
 * stop.
 * 
 * 
 * Given the integer array fruits, return the maximum number of fruits you can
 * pick.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees
 * [1,2].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class _0904_FruitIntoBaskets{
// @lc code=start
    class Solution {
        public int totalFruit(int[] fruits) {
            int maxFruitNums = 0;
            Map<Integer, Integer> fruitTypes = new HashMap<>();
            int left = 0, right = 0;
            while(right < fruits.length){
                if(fruitTypes.get(fruits[right]) != null){
                    fruitTypes.put(fruits[right], fruitTypes.get(fruits[right]) + 1);
                }else{
                    fruitTypes.put(fruits[right], 1);
                }
                while(fruitTypes.size() >= 3){
                    fruitTypes.put(fruits[left], fruitTypes.get(fruits[left]) - 1);
                    if(fruitTypes.get(fruits[left]) == 0){
                        fruitTypes.remove(fruits[left]);
                    }
                    left++;
                }
                int len = right - left + 1;
                if(len > maxFruitNums){
                    maxFruitNums = len;
                }
                right++;
            }
            return maxFruitNums;
        }
    }
// @lc code=end

// test
    @Test
    public void testTotalFruitWithTwoFruitTypes() {
        int[] fruits = {1, 2, 1};
        Solution solution = new Solution();
        int expected = 3;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testTotalFruitWithThreeFruitTypes() {
        int[] fruits = {0, 1, 2, 2};
        Solution solution = new Solution();
        int expected = 3;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testTotalFruitWithFourFruitTypes() {
        int[] fruits = {1, 2, 3, 2, 2};
        Solution solution = new Solution();
        int expected = 4;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testTotalFruitWithAllSameFruitType() {
        int[] fruits = {1, 1, 1, 1};
        Solution solution = new Solution();
        int expected = 4;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testTotalFruitWithEmptyArray() {
        int[] fruits = {};
        Solution solution = new Solution();
        int expected = 0;
        int actual = solution.totalFruit(fruits);
        assertEquals(expected, actual);
    }

}


