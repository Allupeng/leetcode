/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] Design Linked List
 *
 * https://leetcode.cn/problems/design-linked-list/description/
 *
 * algorithms
 * Medium (34.67%)
 * Likes:    843
 * Dislikes: 0
 * Total Accepted:    233.1K
 * Total Submissions: 672.4K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n' +
  '[[],[1],[3],[1,2],[1],[1],[1]]'
 *
 * Design your implementation of the linked list. You can choose to use a
 * singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val
 * is the value of the current node, and next is a pointer/reference to the
 * next node.
 * If you want to use the doubly linked list, you will need one more attribute
 * prev to indicate the previous node in the linked list. Assume all nodes in
 * the linked list are 0-indexed.
 * 
 * Implement the MyLinkedList class:
 * 
 * 
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the index^th node in the linked list. If
 * the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of
 * the linked list. After the insertion, the new node will be the first node of
 * the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of
 * the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the
 * index^th node in the linked list. If index equals the length of the linked
 * list, the node will be appended to the end of the linked list. If index is
 * greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the index^th node in the linked list,
 * if the index is valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get",
 * "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * 
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
 * deleteAtIndex.
 * 
 * 
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _0707_DesignLinkedList {
// @lc code=start
    class Node{
        public int val;
        public Node next;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {
        // 头节点
        Node dummyNode;

        // 记录当前链表有多少个值
        int len;

        // Initializes the MyLinkedList object
        public MyLinkedList() {
           dummyNode = new Node(-1, null);
           len = 0;
        }

        public int get(int index) {
            if(index < 0 || index >= len){
                return -1;
            }
            Node cur = dummyNode.next;
            while(index != 0){
                cur = cur.next;
                index--;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(len, val);
        }

        public void addAtIndex(int index, int val) {
            if(index > len){
                return;
            }
            if(index < 0){
                index = 0;
            }
            Node pre = dummyNode;
            while(index != 0){
                pre = pre.next;
                index--;
            }
            pre.next = new Node(val, pre.next);
            len++;
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index >= len){
                return;
            }
            if(index == 0 && dummyNode.next == null){
                return;
            }
            Node pre = dummyNode;
            while(index != 0){
                pre = pre.next;
                index--;
            }
            pre.next = pre.next.next;
            len--;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

    @Test
    public void testAddAtHead() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        assertEquals(1, list.get(0));
        list.addAtHead(2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void testAddAtTail() {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        assertEquals(1, list.get(0));
        list.addAtTail(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        MyLinkedList list = new MyLinkedList();
        list.addAtIndex(0, 1);
        assertEquals(1, list.get(0));
        list.addAtIndex(0, 2);
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
        list.addAtIndex(1, 3);
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(1, list.get(2));
    }

    @Test
    public void testDeleteAtIndex() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        list.deleteAtIndex(1);
        assertEquals(3, list.get(0));
        assertEquals(1, list.get(1));
        list.deleteAtIndex(1);
        assertEquals(3, list.get(0));
        assertEquals(-1, list.get(1));
    }

    @Test
    public void testGet() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtHead(2);
        list.addAtHead(3);
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(-1, list.get(3));
    }

}




