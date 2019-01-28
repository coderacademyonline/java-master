package leetcode.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     LeetCode第232题：栈实现队列
 *     使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。
 示例:

 MyQueue queue = new MyQueue();

 queue.push(1);
 queue.push(2);
 queue.peek();  // 返回 1
 queue.pop();   // 返回 1
 queue.empty(); // 返回 false
 说明:

 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/28 10:56
 */
public class StackForQueue {

    /**
     * 实现栈的底层list
     */
    private List<Integer> stack1;

    private List<Integer> stack2;

    /** Initialize your data structure here. */
    public StackForQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (this.empty()){
            stack1.add(x);
        }else{
            stack2.add(x);
            stack2.addAll(stack1);
            stack1 = stack2;
            // 清空stack2
            stack2 = new LinkedList<>();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int pop = stack1.get(stack1.size()-1);
        stack1.remove(stack1.size()-1);
        return pop;
    }

    /** Get the front element. */
    public int peek() {
        return stack1.get(stack1.size()-1);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.size() == 0;
    }

    public static void main(String[] args) {
        StackForQueue stackForQueue = new StackForQueue();
        stackForQueue.push(1);
        stackForQueue.push(2);
        stackForQueue.push(3);
        System.out.println(stackForQueue.stack1);
        System.out.println(stackForQueue.peek());
        System.out.println(stackForQueue.pop());
        System.out.println(stackForQueue.empty());
        System.out.println(stackForQueue.peek());
        System.out.println(stackForQueue.pop());
        System.out.println(stackForQueue.peek());
        System.out.println(stackForQueue.pop());
        System.out.println(stackForQueue.empty());
    }
}
