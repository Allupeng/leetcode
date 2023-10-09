/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.cn/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (56.03%)
 * Likes:    705
 * Dislikes: 0
 * Total Accepted:    398.7K
 * Total Submissions: 711.6K
 * Testcase Example:  '"leetcode"'
 *
 * Given a string s, find the first non-repeating character in it and return
 * its index. If it does not exist, return -1.
 * 
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 * 
 * 
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _0387_FirstUniqueCharacterInAString {
// @lc code=start
    class Solution {
        public int firstUniqChar(String s) {
            // 定义两个Map
            Map<Character, Integer> indexMap = new HashMap<>();
            Map<Character, Integer> frequentMap = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                indexMap.putIfAbsent(ch, i);
                frequentMap.compute(ch, (key, value) -> value == null ? 1 : value + 1);
            }
            for (char ch : frequentMap.keySet()){
                if (frequentMap.get(ch) == 1){
                    return indexMap.get(ch);
                }
            }
            return -1;
        }
    }
// @lc code=end
}

