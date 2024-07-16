/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (68.01%)
 * Likes:    1878
 * Dislikes: 0
 * Total Accepted:    692.4K
 * Total Submissions: 1M
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * 
 * 
 */

import java.util.*;

public class _0049_GroupAnagrams {
    // @lc code=start
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList<>();
            Map<String, List<String>> anagramsMap = new HashMap<>();
            for (String str: strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                List<String> list = anagramsMap.getOrDefault(sorted, new ArrayList());
                list.add(str);
                anagramsMap.put(sorted, list);
            }
            List<List<String>> result = new ArrayList<>();
            for(Map.Entry<String, List<String>> entry : anagramsMap.entrySet()){
                result.add(entry.getValue());
            }
            return result;
        }
    }
// @lc code=end
}

