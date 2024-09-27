package hot100;

import java.util.*;

public class _0049_GroupAnagrams {
    // @lc code=start
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return Collections.emptyList();
            Map<String, List<String>> anagramsMap = new ArrayList();
            for(String str : strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                anagramsMap.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
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

