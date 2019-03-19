package leetcode.stack;

import java.util.Stack;

/**
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 输入：S = "ab#c", T = "ad#c"
   输出：true
   解释：S 和 T 都会变成 “ac”。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/18 16:22
 */
public class LeetCode844 {

    public boolean backspaceCompare(String S, String T) {
        Stack<String> stackS = this.strToStack(S);
        Stack<String> stackT = this.strToStack(T);

        String s = this.stackToString(stackS);
        String t = this.stackToString(stackT);

        return s.equals(t);
    }

    private Stack<String> strToStack(String str){

        Stack<String> stack = new Stack<>();

        char[] strs = str.toCharArray();
        for(char c:strs){
            String s = String.valueOf(c);
            if ("#".equals(s)){
                if (!stack.empty()){
                    stack.pop();
                }
            }else {
                stack.push(s);
            }
        }
        return stack;
    }

    private String stackToString(Stack<String> stack){
        StringBuffer buffer = new StringBuffer("");
        while (!stack.empty()){
            buffer.append(stack.pop());
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        LeetCode844 leetCode844 = new LeetCode844();
        String S = "a#c", T = "b";
        System.out.println(leetCode844.backspaceCompare(S,T));
    }
}
