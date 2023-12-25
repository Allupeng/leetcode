/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] Can Place Flowers
 *
 * https://leetcode.cn/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (32.38%)
 * Likes:    568
 * Dislikes: 0
 * Total Accepted:    166.1K
 * Total Submissions: 512.8K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return true if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule and
 * false otherwise.
 * 
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 * 
 * 
 */

public class _0605_CanPlaceFlowers{
// @lc code=start
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int suitableFlowers = 0;
            if(flowerbed.length == 0){
                return false;
            }
            if(flowerbed.length == 1){
                if(flowerbed[0] == 0){
                    suitableFlowers++;
                }
                return suitableFlowers >= n;
            }
            for(int i = 0; i < flowerbed.length; i++){
                if(i == 0){
                    if(flowerbed[i] == 0 && flowerbed[1] == 0){
                        suitableFlowers ++;
                        flowerbed[i] = 1;
                    }
                    continue;   
                }
                if(i == flowerbed.length - 1){
                    if(flowerbed[i] == 0 && flowerbed[i - 1] == 0){
                        suitableFlowers ++;
                        flowerbed[i] = 1;
                    }
                    continue;
                }
                if(flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                    suitableFlowers ++;
                    flowerbed[i] = 1;
                }
            }
            return suitableFlowers >= n;
        }
    }
// @lc code=end
}
