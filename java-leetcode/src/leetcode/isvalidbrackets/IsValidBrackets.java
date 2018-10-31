package leetcode.isvalidbrackets;


import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *      给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
         有效字符串需满足：
         左括号必须用相同类型的右括号闭合。
         左括号必须以正确的顺序闭合。
       注意空字符串可被认为是有效字符串。
 * 例子：输入: "{[]}"
        输出: true
        输入: "([)]"
        输出: false
        输入："()[]{}"
        输出：true
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/29 17:57
 */
public class IsValidBrackets {

    public static void main(String[] args) {
        IsValidBrackets main = new IsValidBrackets();
        System.err.println(main.isValid("([)]"));
    }

    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        if (s == null || "".equals(s)) {
            return false;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack stack = new Stack(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String key = String.valueOf(c);

            if (map.containsKey(key)) {
                // 如果栈为空时，进栈的是向左开的括号，则不合法
                if (stack.isEmpty()) {
                    return false;
                } else {
                    // 如果栈不是空，则查看栈顶元素是否与他匹配
                    String value = stack.peekVal();
                    // 若不匹配则返回false
                    if (!map.get(key).equals(value)) {
                        return false;
                    } else {
                        // 如果匹配，则弹出元素
                        stack.popVal();
                    }
                }
            } else {
                // 若进来的是向右开的括号，则插入数据
                stack.pushVal(key);
            }
        }
        return stack.isEmpty();
    }

    class Stack {
        /**
         * 底层实现是一个数组
         */
        private String[] stacks;
        /**
         * 栈顶指针
         */
        private int top;

        public Stack(int length) {
            stacks = new String[length];
            top = -1;
        }

        /**
         * 插入数据
         *
         * @param value
         */
        public void pushVal(String value) {
            stacks[++top] = value;
        }

        /**
         * 弹出元素
         *
         * @return
         */
        public String popVal() {
            return stacks[top--];
        }

        /**
         * 查看元素
         *
         * @return
         */
        public String peekVal() {
            return stacks[top];
        }

        /**
         * 判断是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return top == -1;
        }
    }
}

