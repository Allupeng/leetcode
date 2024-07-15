package hot100;/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.cn/problems/lru-cache/description/
 *
 * algorithms
 * Medium (53.58%)
 * Likes:    3151
 * Dislikes: 0
 * Total Accepted:    630.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design a data structure that follows the constraints of a Least Recently
 * Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size
 * capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys
 * exceeds the capacity from this operation, evict the least recently used
 * key.
 * 
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 10^4
 * 0 <= value <= 10^5
 * At most 2 * 10^5 calls will be made to get and put.
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class _0146_LruCache {
// @lc code=start
    class LruNode{
        int key;
        int value;
        LruNode prev;
        LruNode next;
        LruNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class LRUCache {
        private Map<Integer, LruNode> cached;
        
        private LruNode head,tail;
        
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cached = new HashMap<>();
            head = new LruNode(-1, -1);
            tail = new LruNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(cached.containsKey(key)){
                LruNode node = cached.get(key);
                deleteCurNode(node);
                addTohead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            LruNode node = cached.get(key);
            if(node != null){
                deleteCurNode(node);
                node.value = value;
                addTohead(node);
                cached.put(key, node);
            }else{
                if(cached.size() >= capacity){
                    LruNode removeNode = tail.prev;
                    deleteCurNode(removeNode);
                    cached.remove(removeNode.key);
                }
                node = new LruNode(key, value);
                addTohead(node);
                cached.put(key, node);
            }
        }

        private void deleteCurNode(LruNode node){
            LruNode prev = node.prev;
            LruNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void addTohead(LruNode cur){
            LruNode next = head.next;
            head.next = cur;
            cur.prev = head;
            cur.next = next;
            next.prev = cur;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
}

