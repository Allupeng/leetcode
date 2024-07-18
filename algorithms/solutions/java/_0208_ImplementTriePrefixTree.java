/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (71.97%)
 * Likes:    1635
 * Dislikes: 0
 * Total Accepted:    325.7K
 * Total Submissions: 452.6K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * 
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * 
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and
 * startsWith.
 * 
 * 
 */

public class _0208_ImplementTriePrefixTree {
// @lc code=start
    class TrieNode{

        private boolean isEndOfWord;
        private TrieNode[] children;

        TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }

        public void put(char ch){
            children[ch - 'a'] = new TrieNode();
        }

        public boolean contains(char ch){
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return children[ch - 'a'];
        }

        public void setEndOfWord(){
            isEndOfWord = true;
        }

        public boolean isEndOfWord(){
            return isEndOfWord;
        }
    }

    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()){
                if (!cur.contains(ch)){
                    cur.put(ch);
                }
                cur = cur.get(ch);
            }
            cur.setEndOfWord();
        }

        public boolean search(String word) {
            TrieNode cur = searchPrefix(word);
            return cur != null && cur.isEndOfWord();
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String prefix){
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()){
                if (!cur.contains(ch)){
                    return null;
                }
                cur = cur.get(ch);
            }
            return cur;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
}

