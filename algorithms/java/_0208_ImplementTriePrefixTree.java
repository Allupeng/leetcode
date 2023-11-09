/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (71.92%)
 * Likes:    1551
 * Dislikes: 0
 * Total Accepted:    290.4K
 * Total Submissions: 403.9K
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
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()){
                if (!node.containsKey(ch)){
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TrieNode trieNode = searchPrefix(word);
            return trieNode != null && trieNode.isEnd();
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String word){
            TrieNode node = root;
            for (char ch : word.toCharArray()){
                if (!node.containsKey(ch)){
                    return null;
                }
                node = node.get(ch);
            }
            return node;
        }
    }

    class TrieNode{
        private final TrieNode[] links;
        private boolean isEnd;

        public TrieNode(){
            int r = 26;
            links = new TrieNode[r];
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
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

