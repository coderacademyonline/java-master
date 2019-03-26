package leetcode.stack;

import java.util.Stack;

/**
 * <p>
 *     有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     说明：

     整数除法只保留整数部分。
     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

 例：
 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 输出: 22
 解释:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/19 15:15
 */
public class LeetCode150 {

    public static void main(String[] args) {
        LeetCode150 leetCode150 = new LeetCode150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(leetCode150.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if ("+".equals(token)){
                // 弹出俩元素做相加后将结果在入栈
                stack.push(stack.pop()+stack.pop());
            }else if ("-".equals(token)){
                Integer t1 = stack.pop();
                Integer t2 = stack.pop();
                stack.push(t2-t1);
            }else if ("*".equals(token)){
                stack.push(stack.pop() * stack.pop());
            }else if ("/".equals(token)){
                Integer t1 = stack.pop();
                Integer t2 = stack.pop();
                stack.push(t2/t1);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
