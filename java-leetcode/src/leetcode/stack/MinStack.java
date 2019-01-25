package leetcode.stack;


/**
 * <p>
 *  设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *   push(x) -- 将元素 x 推入栈中。
 *   pop() -- 删除栈顶的元素。
 *   top() -- 获取栈顶元素。
 *   getMin() -- 检索栈中的最小元素。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/24 19:12
 */
public class MinStack {
    /**
     * 用于实现栈的数组
     */
    int[] stacks;
    /**
     * 栈顶指针
     */
    int top;

    public MinStack() {
        top = -1;
        stacks = new int[2];
    }

    /**
     * 入栈
     * @param x
     */
    public void push(int x) {
        if(top >= stacks.length*(0.75)-1){
            // 扩容
            int[] newStack = new int[stacks.length * 2];
            for(int i=0;i<=top;i++){
                newStack[i] = stacks[i];
            }
            newStack[++top] = x;
            stacks = newStack;
        }else{
            stacks[++top] = x;
        }
    }

    /**
     * 弹出栈顶元素
     */
    public void pop() {
        top--;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public int top() {
        return stacks[top];
    }

    /**
     * 找出栈的最小值
     * @return
     */
    public int getMin() {
        if (top<=-1){
            return 0;
        }
        int min = stacks[0];
        for(int i=0;i<=top;i++){
            if (min>stacks[i]){
                min = stacks[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.err.println(minStack.getMin());
        minStack.pop();
        System.err.println(minStack.getMin());
        minStack.pop();
        System.err.println(minStack.getMin());
        minStack.pop();
        System.err.println(minStack.getMin());
    }

}
