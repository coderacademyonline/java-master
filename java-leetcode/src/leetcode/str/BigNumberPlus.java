package leetcode.str;

/**
 * <p>
 *     两个超大整数相加，注：整除很大，也可能超出了long的存储范围
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/30 11:07
 */
public class BigNumberPlus {

    public static void main(String[] args) {
        String bigNum1 = "426709752318";
        String bigNum2 = "95481253129";
        BigNumberPlus bigNumberPlus = new BigNumberPlus();
        System.err.println(bigNumberPlus.plus(bigNum1,bigNum2));
    }

    private String plus(String bigNum1,String bigNum2){

        if (bigNum1 == null || "".equals(bigNum1) || "0".equals(bigNum1)){
            return bigNum2;
        }
        if (bigNum2 == null || "".equals(bigNum2) || "0".equals(bigNum2)){
            return bigNum1;
        }

        BigStack bigStack1 = this.strToStack(bigNum1);
        BigStack bigStack2 = this.strToStack(bigNum2);
        int resultSize = (bigNum1.length()>=bigNum2.length()?bigNum1.length():bigNum2.length()) + 1;
        BigStack resultStack = new BigStack(resultSize);
        // 是否进位
        boolean isCarry = false;
        while (bigStack1.isNotEmpty() || bigStack2.isNotEmpty()){
            int v1 = bigStack1.pop();
            int v2 = bigStack2.pop();
            int sum = v1+v2;

            if (isCarry){
                // 当前栈顶元素，如果有进位则需要将进位加上,此时需要弹出栈顶元素，再重新入栈
                int top = resultStack.pop();
                sum += top;
            }
            char[] sums = String.valueOf(sum).toCharArray();
            for(int i=sums.length-1;i>=0;i--){
                resultStack.push(sums[i]);
            }

            if(sum >= 10){
                isCarry = true;
            }else{
                isCarry = false;
            }
        }

        StringBuffer buffer = new StringBuffer();
        while (resultStack.isNotEmpty()){
            buffer.append(resultStack.pop());
        }
        return buffer.toString();
    }

    private BigStack strToStack(String str){
        char[] chars = str.toCharArray();
        BigStack bigStack = new BigStack(chars.length);
        for(char c:chars){
            bigStack.push(c);
        }
        return bigStack;
    }
}

class BigStack{

    private int[] stacks;

    private int top;

    public BigStack(int maxSize){
        stacks = new int[maxSize];
        top = -1;
    }

    public void push(char value){
        stacks[++top] = Integer.parseInt(String.valueOf(value));
    }

    public int peek(){
        if (isEmpty()) {
            return 0;
        }
        return stacks[top];
    }

    public int pop(){
        if (isEmpty()) {
            return 0;
        }
        return stacks[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isNotEmpty(){
        return !isEmpty();
    }
}
