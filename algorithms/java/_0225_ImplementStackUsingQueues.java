/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (66.14%)
 * Likes:    723
 * Dislikes: 0
 * Total Accepted:    288.8K
 * Total Submissions: 436.6K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * 
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * 
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * 
 * 
 * 
 * Follow-up: Can you implement the stack using only one queue?
 * 
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class _0225_ImplementStackUsingQueues {
// @lc code=start
    class MyStack {

        Queue<Integer> queue1, queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.offer(x);
        }

        // when pop, queue1 move all elements to queue2 except last one element, return it
        public int pop() {
            while(queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            int result = queue1.poll();
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            return result;
        }

        public int top() {
            while(queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            int result = queue1.poll();
            queue2.offer(result);
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            return result;
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

    @Test
    public void test1(){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }
}

