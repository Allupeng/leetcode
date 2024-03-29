/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (67.79%)
 * Likes:    1619
 * Dislikes: 0
 * Total Accepted:    516.4K
 * Total Submissions: 761.6K
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0049_GroupAnagrams {
// @lc code=start
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> sortedStrMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++){
                char[] origin = strs[i].toCharArray();
                Arrays.sort(origin);
                String sorted = new String(origin);
                List<String> list = sortedStrMap.get(sorted);
                if (list == null){
                    list = new ArrayList<>();
                }
                list.add(strs[i]);
                sortedStrMap.put(sorted, list);
            }
            List<List<String>> result = new ArrayList<>();
            for (List<String> value : sortedStrMap.values()){
                result.add(value);
            }
            return result;
        }
    }
// @lc code=end
}

