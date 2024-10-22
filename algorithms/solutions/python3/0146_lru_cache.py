#
# @lc app=leetcode.cn id=146 lang=python3
#
# [146] LRU Cache
#
# https://leetcode.cn/problems/lru-cache/description/
#

# @lc code=start
class LRUNode:
  def __init__(self, key, value) -> None:
     self.key = key
     self.val = value
     self.next = None
     self.prev = None

class LRUCache:
    
    def __init__(self, capacity: int):
      self.capacity = capacity
      self.cached = {}
      self.head = LRUNode(-1, -1)
      self.tail = LRUNode(-1, -1)
      self.head.next = self.tail
      self.tail.prev = self.head
    
    def delete_cur_node(self, cur: LRUNode):
      next = cur.next
      prev = cur.prev
      prev.next = next
      next.prev = prev
    
    def add_to_head(self, cur: LRUNode):
      next = self.head.next
      self.head.next = cur
      cur.prev = self.head
      cur.next = next
      next.prev = cur

    def get(self, key: int) -> int:
      if key not in self.cached:
        return -1
      cur = self.cached[key]
      self.delete_cur_node(cur)
      self.add_to_head(cur)
      return cur.val
        

    def put(self, key: int, value: int) -> None:
      if key not in self.cached:
        if len(self.cached) >= self.capacity:
          delete_key = self.tail.prev.key
          delete_node = self.cached[delete_key]
          self.delete_cur_node(delete_node)
          self.cached.pop(delete_key)
        node = LRUNode(key, value)
        self.cached[key] = node
        self.add_to_head(node)
      else:
        node = self.cached[key]
        self.delete_cur_node(node)
        node.val = value
        self.add_to_head(node)
      
                


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end

