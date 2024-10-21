#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU Cache
#
# https://leetcode.cn/problems/lru-cache/description/
#

# @lc code=start
class LRUCache:
    class LRUNode:
      prev = next = None
      key = value = 0
      def __init__(self, key, value):
         self.key = key
         self.value = value
    
    head = tail = None
    cached = None # the key is int , the value is LRUNode
    capacity = 0
    
    def __init__(self, capacity: int):
        self.head, self.tail = self.LRUNode(-1, -1), self.LRUNode(-1, -1)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.capacity = capacity
        self.cached = {}
    
    def addToHead(self, cur: LRUNode):
        next = self.head.next
        cur.next = next
        next.prev = cur
        cur.prev = self.head
        self.head.next = cur
        
    def deleteCurNode(self, cur: LRUNode):
        prev = cur.prev
        next = cur.next
        prev.next = next
        next.prev = prev

    def get(self, key: int) -> int:
      if key not in self.cached:
        return -1
      node = self.cached[key]
      self.deleteCurNode(node)
      self.addToHead(node)
      return node.value
        

    def put(self, key: int, value: int) -> None:
      if key not in self.cached:
        if self.capacity <= len(self.cached):
          deleteNode = self.tail.prev
          self.cached.pop(deleteNode.key)
          self.deleteCurNode(deleteNode)
        node = self.LRUNode(key, value)
        self.cached[key] = node
        self.addToHead(node)
      else:
        node = self.cached[key]
        self.deleteCurNode(node)
        node.value = value
        self.addToHead(node)
                


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

