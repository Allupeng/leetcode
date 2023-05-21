/**
 * 3 situation
 * if word1.len == word2.len, merge alternately
 * if word1.len > word2.len or word1.len < word2.len,
 * first merge alternately min(word1.len, word2.len)
 * and merge string max(word1, word2).substring(min(word1.len, word2.len))
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        /**
         * 1 <= word1.length, word2.length <= 100
         * word1 and word2 consist of lowercase English letters.
         */
        int word1Index = 0;
        int word2Index = 0;
        StringBuilder result = new StringBuilder();
        while(word1Index < word1.length() && word2Index < word2.length()){
            result.append(word1.charAt(word1Index++)).append(word2.charAt(word2Index++));
        }
        int minLen = Math.min(word1.length(), word2.length());
        String suffixStr = word1.length() > word2.length() ? word1.substring(minLen) : word2.substring(minLen);
        result.append(suffixStr);
        return result.toString();
    }
}