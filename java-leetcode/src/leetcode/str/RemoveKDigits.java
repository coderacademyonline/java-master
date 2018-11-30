package leetcode.str;

/**
 * <p>
 *   给定一个整数，从整数中去掉k个数字，要求剩下的新整数尽可能小。给定的整数大小可以超过long类型的范围，所以需要用字符串来表示。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/29 14:35
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String num = "1432219";
        int k = 3;
        System.out.println(removeKDigits.removeKDigits(num, k));
    }

    public String removeKDigits(String num, int k) {
        if (num == null || num.length() == 0 || num.length() == k) {
            return "0";
        }
        if (k == 0) {
            return num;
        }

        int newLength = num.length() - k;

        char[] nums = num.toCharArray();
        Stack stack = new Stack(nums.length);
        for(int i=0;i<nums.length;i++){
            String value = String.valueOf(nums[i]);
            String stackPop = stack.peek();
            while (k>0 && stackPop != null && (Integer.parseInt(value) < Integer.parseInt(stackPop))) {
                // 栈顶弹出，入当前值
                stack.pop();
                stackPop = stack.peek();
                k--;
            }
             stack.push(value);
        }

        StringBuffer buffer = new StringBuffer();
        StringBuffer zero = new StringBuffer();
        while (!stack.isEmpty()) {
            String value = stack.pop();
            if ("0".equals(value)){
                zero.append(value);
            }else{
                if (zero.length() > 0){
                    buffer.append(zero);
                }
                buffer.append(value);
                zero = new StringBuffer();
            }
        }
        if (buffer.length() == 0) {
            return "0";
        }
        if (newLength > buffer.length()){
            newLength = buffer.length();
        }
        return buffer.reverse().substring(0,newLength);
    }

    public class Stack {

        /**
         * 栈底层实现的数组
         */
        private String[] stacks;
        /**
         * 栈顶指针
         */
        private int top;

        public Stack() {
            stacks = new String[8];
            top = -1;
        }

        public Stack(int maxSize) {
            stacks = new String[maxSize];
            top = -1;
        }

        /**
         * 入栈
         *
         * @param val
         */
        public void push(String val) {
            stacks[++top] = val;
        }

        /**
         * 查看栈顶元素
         *
         * @return
         */
        public String peek() {
            if (this.isEmpty()) {
                return null;
            }
            return stacks[top];
        }

        /**
         * 弹出栈顶元素
         *
         * @return
         */
        public String pop() {
            if (this.isEmpty()) {
                return null;
            }
            return stacks[top--];
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
