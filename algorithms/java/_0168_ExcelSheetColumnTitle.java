/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.cn/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (44.05%)
 * Likes:    652
 * Dislikes: 0
 * Total Accepted:    143.9K
 * Total Submissions: 326.6K
 * Testcase Example:  '1'
 *
 * Given an integer columnNumber, return its corresponding column title as it
 * appears in an Excel sheet.
 * 
 * For example:
 * 
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: columnNumber = 1
 * Output: "A"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: columnNumber = 28
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: columnNumber = 701
 * Output: "ZY"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= columnNumber <= 2^31 - 1
 * 
 * 
 */

import org.junit.Assert;
import org.junit.Test;

public class _0168_ExcelSheetColumnTitle {
// @lc code=start
    class Solution {
        public String convertToTitle(int columnNumber) {
            //商余转化法
            StringBuilder stringBuilder = new StringBuilder();
            while (columnNumber > 0){
                int c = columnNumber % 26;
                // c == 0特殊处理
                if (c == 0){
                    c = 26;
                    columnNumber -= 1;
                }
                stringBuilder.append((char) ('A' + c - 1));
                columnNumber /= 26;
            }
            return stringBuilder.reverse().toString();
        }
    }
// @lc code=end

    @Test
    public void test(){
        Solution solution = new Solution();
        Assert.assertEquals("ZY", solution.convertToTitle(701));
    }
}

