/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] Reverse Bits
 *
 * https://leetcode.cn/problems/reverse-bits/description/
 *
 * algorithms
 * Easy (71.97%)
 * Likes:    656
 * Dislikes: 0
 * Total Accepted:    221.7K
 * Total Submissions: 308K
 * Testcase Example:  '00000010100101000001111010011100'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Note:
 * 
 * 
 * Note that in some languages, such as Java, there is no unsigned integer
 * type. In this case, both input and output will be given as a signed integer
 * type. They should not affect your implementation, as the integer's internal
 * binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement
 * notation. Therefore, in Example 2 above, the input represents the signed
 * integer -3 and the output represents the signed integer -1073741825.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100
 * represents the unsigned integer 43261596, so return 964176192 which its
 * binary representation is 00111001011110000010100101000000.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101
 * represents the unsigned integer 4294967293, so return 3221225471 which its
 * binary representation is 10111111111111111111111111111111.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The input must be a binary string of length 32
 * 
 * 
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 */

import org.junit.Test;


public class _0190_ReverseBits {
// @lc code=start
    public class Solution {
        // you need treat n as an unsigned value
        // 00000010100101000001111010011100
        // [0, 0, 1, 3, 7, 14, 28, 57, 114, 229, 459, 919, 1839, 3678, 7356, 14712, 29424, 58848, 117697, 235394, 470789, 941578, 1883156, 3766313, 7532626, 15065253, 30130506, 60261012, 120522024, 241044048, 482088096, 964176192]
        // [0, 0, 2, 6, 14, 28, 56, 114, 228, 458, 918, 1838, 3678, 7356, 14712, 29424, 58848, 117696, 235394, 470788, 941578, 1883156, 3766312, 7532626, 15065252, 30130506, 60261012, 120522024, 241044048, 482088096, 964176192, 1928352384]

    public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++){
                result = result << 1;
                result = result | (n & 1);
                n = n >> 1;
            }
            return result;
        }
    }
// @lc code=end
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.reverseBits(43261596);
    }
}

