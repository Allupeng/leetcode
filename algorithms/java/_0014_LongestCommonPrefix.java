/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.cn/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (43.49%)
 * Likes:    2924
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2.7M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * 
 * 
 */

public class _0014_LongestCommonPrefix {
// @lc code=start
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1){
                return strs[0];
            }
            int minLen = strs[0].length();
            for (int i = 1; i < strs.length; i++){
                minLen = Math.min(strs[i].length(), minLen);
            }
            StringBuilder commonPrefixStr = new StringBuilder();
            for (int i = 0; i < minLen; i++){
                for (int j = 0; j < strs.length - 1; j++){
                    if (strs[j].charAt(i) != strs[j + 1].charAt(i)){
                        return commonPrefixStr.toString();
                    }
                }
                commonPrefixStr.append(strs[0].charAt(i));
            }
            return commonPrefixStr.toString();
        }
    }
// @lc code=end

}
