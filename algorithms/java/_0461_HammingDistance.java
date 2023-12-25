/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] Hamming Distance
 *
 * https://leetcode.cn/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (81.88%)
 * Likes:    717
 * Dislikes: 0
 * Total Accepted:    287.3K
 * Total Submissions: 350.9K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, return the Hamming distance between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 3, y = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x, y <= 2^31 - 1
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0461_HammingDistance {
// @lc code=start
    class Solution {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int count = 0;
            while(z != 0){
                if((z & 1) == 1){
                    count++;
                }
                z = z >> 1;
            }
            return count;
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        Assert.assertEquals(solution.hammingDistance(1, 4), 2);
    }
}

