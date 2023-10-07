/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 *
 * https://leetcode.cn/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (71.37%)
 * Likes:    397
 * Dislikes: 0
 * Total Accepted:    171.1K
 * Total Submissions: 239.7K
 * Testcase Example:  '"A"'
 *
 * Given a string columnTitle that represents the column title as appears in an
 * Excel sheet, return its corresponding column number.
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
 * Input: columnTitle = "A"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: columnTitle = "AB"
 * Output: 28
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: columnTitle = "ZY"
 * Output: 701
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 * 
 * 
 */

public class _0171_ExcelSheetColumnNumber {
// @lc code=start
    class Solution {
        public int titleToNumber(String columnTitle) {
            int result = 0;
            for (int i = 0; i < columnTitle.length(); i++){
                int value = columnTitle.charAt(i) - 'A' + 1;
                result += Math.pow(26, columnTitle.length() - 1 - i) * value;
            }
            return result;
        }
    }
// @lc code=end
}

