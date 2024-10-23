#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU Cache
#
# https://leetcode.cn/problems/lru-cache/description/
#

# @lc code=start

class LRUNode:
    def __init__(self, key, val) -> None:
        self.key = key
        self.val = val
        self.next = None
        self.prev = None

class LRUCache:
    
    def __init__(self, capacity: int):
      self.capacity = capacity
      self.cache = {}
      self.head = LRUNode(-1, -1)
      self.tail = LRUNode(-1, -1)
      self.head.next = self.tail
      self.tail.prev = self.head
    
    def deleteCurNode(self, cur: LRUNode):
      next = cur.next
      prev = cur.prev
      next.prev = prev
      prev.next = next
    
    def addToHead(self, cur: LRUNode):
      next = self.head.next
      self.head.next = cur
      cur.prev = self.head
      cur.next = next
      next.prev = cur

    def get(self, key: int) -> int:
      if key not in self.cache:
        return -1
      cur = self.cache[key]
      self.deleteCurNode(cur)
      self.addToHead(cur)
      return cur.val

    def put(self, key: int, value: int) -> None:
      if key not in self.cache:
        if len(self.cache) >= self.capacity:
          delete_key = self.tail.prev.key
          self.deleteCurNode(self.cache[delete_key])
          self.cache.pop(delete_key)
        node = LRUNode(key, value)
        self.cache[key] = node
        self.addToHead(node)
      else:
        node = self.cache[key]
        self.deleteCurNode(node)
        node.val = value
        self.addToHead(node)
        
        
          
          
      
                


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

