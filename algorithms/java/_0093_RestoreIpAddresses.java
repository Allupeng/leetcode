/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (58.09%)
 * Likes:    1246
 * Dislikes: 0
 * Total Accepted:    344K
 * Total Submissions: 592.2K
 * Testcase Example:  '"25525511135"'
 *
 * A valid IP address consists of exactly four integers separated by single
 * dots. Each integer is between 0 and 255 (inclusive) and cannot have leading
 * zeros.
 * 
 * 
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but
 * "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP
 * addresses.
 * 
 * 
 * Given a string s containing only digits, return all possible valid IP
 * addresses that can be formed by inserting dots into s. You are not allowed
 * to reorder or remove any digits in s. You may return the valid IP addresses
 * in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 20
 * s consists of digits only.
 * 
 * 
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0093_RestoreIpAddresses {
// @lc code=start
    class Solution {
        private final List<String> result = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.equals("")){
                return result;
            }
            backtrace(new StringBuilder(s), 0, 0);
            return result;
        }

        private void backtrace(StringBuilder s, int startIndex, int pointNum){
            //如果已经有三个. 并且最后一个地址段符合有效地址，加入结果
            if (pointNum == 3 && isValidAddress(s.substring(startIndex))){
                result.add(s.toString());
                return;
            }
            for (int i = startIndex; i < s.length(); i++){
                String subString = s.substring(startIndex, i + 1);
                if (isValidAddress(subString)){
                    // 在 i + 1处添加.
                    s.insert(i + 1, ".");
                    pointNum++;
                    backtrace(s, i + 2, pointNum);
                    pointNum--;
                    s.deleteCharAt(i + 1);
                    // 删除 i + 1的.
                }else {
                    break;
                }
            }
        }

        private boolean isValidAddress(String subString){
            if (subString == null || subString.equals("")){
                return false;
            }
            if (subString.length() != 1 && subString.charAt(0) == '0') return false;
            if (subString.length() >= 4) return false;
            int address = Integer.parseInt(subString);
            return address >= 0 && address <= 255;
        }
    }
// @lc code=end
    @Test
    public void test(){
        Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses("0000");
        System.out.println(strings);
    }
}

