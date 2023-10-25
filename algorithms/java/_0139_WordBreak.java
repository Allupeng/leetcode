/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.cn/problems/word-break/description/
 *
 * algorithms
 * Medium (54.53%)
 * Likes:    2321
 * Dislikes: 0
 * Total Accepted:    495.2K
 * Total Submissions: 908.1K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary
 * words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in
 * the segmentation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * 
 * 
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0139_WordBreak {
// @lc code=start
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.equals("")){
                return true;
            }
            Set<String> wordSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++){
                for(int j = 0; j < i; j++){
                    if(dp[j] && wordSet.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }
            return dp[s.length()];
        }
    }
// @lc code=end
}

