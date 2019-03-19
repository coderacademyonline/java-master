package leetcode.stack;

import java.util.Stack;

/**
 * <p>
 *     LeetCode第682题：棒球比赛得分
 *     你现在是棒球比赛记录员。
         给定一个字符串列表，每个字符串可以是以下四种类型之一：
         1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
         2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
         3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
         4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。

         每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
         你需要返回你在所有回合中得分的总和。

 示例 1:

 输入: ["5","2","C","D","+"]
 输出: 30
 解释:
 第1轮：你可以得到5分。总和是：5。
 第2轮：你可以得到2分。总和是：7。
 操作1：第2轮的数据无效。总和是：5。
 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/29 21:51
 */
public class LeetCode682 {

    public static void main(String[] args) {
        LeetCode682 leetCode682 = new LeetCode682();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        Integer totalPoints = leetCode682.calPoints(ops);
        System.err.println("总分："+totalPoints);
    }


    /**
     * 用于存储有效轮的每轮得分
      */
    private Stack<Integer> stack = new Stack<>();

    private Integer totalPoints = 0;

    public int calPoints(String[] ops) {

        for(String op:ops){
            if (stack.empty()){
                totalPoints = Integer.valueOf(op);
                stack.push(Integer.valueOf(op));
            } else if ("+".equals(op)){
                // 获取前两轮的有效分数和
                int thisScore = this.getTheTwoEffectiveNum();
                //入栈
                stack.push(thisScore);
                totalPoints += thisScore;
            }else if ("C".equals(op)){
                // 上一轮有效回合得分无效
                totalPoints -= stack.pop();
            }else if ("D".equals(op)){
                Integer thisPoints = stack.peek();
                stack.push(thisPoints * 2) ;
                totalPoints += stack.peek();
            }else {
                //下一个是数字
                // 本轮积分数
                stack.push(Integer.valueOf(op));
                totalPoints += stack.peek();
            }
        }

        return totalPoints;
    }

    /**
     * 获取前两轮的有效得分
     * @return
     */
    public int getTheTwoEffectiveNum(){
        if (stack.empty()){
            return 0;
        }
        // 先弹出栈顶元素
        int pop = stack.pop();
        // 查看前两轮的第一轮的分数
        int peek = 0;
        if (!stack.empty()){
            peek = stack.peek();
        }
        // 再塞会栈顶元素
        stack.push(pop);
        return pop+peek;
    }
}
