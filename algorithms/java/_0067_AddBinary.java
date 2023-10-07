/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.cn/problems/add-binary/description/
 *
 * algorithms
 * Easy (52.91%)
 * Likes:    1108
 * Dislikes: 0
 * Total Accepted:    347.8K
 * Total Submissions: 657.5K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * 
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0067_AddBinary {
// @lc code=start
    class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            StringBuilder result = new StringBuilder();
            int ca = 0;
            while (i >= 0 || j >= 0){
                int va = i >= 0 ? a.charAt(i) - '0' : 0;
                int vb = j >= 0 ? b.charAt(j) - '0' : 0;
                int sum = va + vb;
                result.append((sum + ca) % 2);
                ca = (sum + ca) / 2;
                i--;
                j--;
            }
            if (ca != 0){
                result.append(ca);
            }
            return result.reverse().toString();
        }
    }
// @lc code=end

    @Test
    public void test(){
        String a = "1", b = "11";
        Solution solution = new Solution();
        Assert.assertEquals("100", solution.addBinary(a,b));
    }
}

