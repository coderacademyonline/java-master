package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     LeetCode第225题：
 *     使用队列实现栈的下列操作：
        push(x) -- 元素 x 入栈
        pop() -- 移除栈顶元素
        top() -- 获取栈顶元素
        empty() -- 返回栈是否为空
 注意:
     你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 *     队列：先进先出
 *     栈：先进后出
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/25 14:32
 */
public class QueueForStack {

    /**
     * 实现队列的底层数组
     */
    private List<Integer> queue1;

    private List<Integer> queue2;

    /** Initialize your data structure here. */
    public QueueForStack() {
        queue1 = new ArrayList<>();
        queue2 = new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(this.empty()){
            // 如果队列1是空的则直接入队列
            queue1.add(x);
        }else {
            // 如果队列不为空，则需要将队列1的元素先移至队列2并清空队列1，将要添加的元素入队列1，然后再将队列2的元素入队列1，并清空队列2
            queue2.addAll(queue1);
            // 清空队列1
            queue1 = new ArrayList<>();
            queue1.add(x);
            queue1.addAll(queue2);
            // 清空队列2
            queue2 = new ArrayList<>();
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int pop = queue1.get(0);
        queue1.remove(0);
        return pop;
    }

    /** Get the top element. */
    public int top() {
        int top = queue1.get(0);
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.size() == 0;
    }

    public static void main(String[] args) {
        QueueForStack queueForStack = new QueueForStack();
        queueForStack.push(1);
        queueForStack.push(2);
        System.out.println(queueForStack.queue1);
        System.out.println(queueForStack.top());
        System.out.println(queueForStack.pop());
        System.out.println(queueForStack.empty());
    }
}
