package leetcode.stack;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *     给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
      注意：n 的值小于15000。
 例如：
 输入: [-1, 3, 2, 0]
 输出: True
 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/20 16:40
 */
public class LeetCode456 {

    public static void main(String[] args) {
        LeetCode456 leetCode456 = new LeetCode456();
        int[] nums = {-1, 3, 2, 0};
        System.out.println(leetCode456.find132pattern(nums));
    }

    /**
     * 基本思想是先规定好较大的值，然后去找比他小的值，再去寻找更小的值,所以循环数组需要倒序循环
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        // 132中的3
        Stack<Integer> stack = new Stack<>();
        // 132中的2
        int last = Integer.MIN_VALUE;

        if (nums.length < 3){
            return false;
        }

        List<LinkedList<Integer>> result = new ArrayList<>();

        for(int i=nums.length-1;i>=0;i--){
            // 这里的nums[i]就是132中的1
            if (nums[i] < last){
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(nums[i]);
                linkedList.add(stack.peek());
                linkedList.add(last);
                result.add(linkedList);
            }

            // 找出132中的2 ，2是3中小于当前值的最大值，循环下一轮中
            while (!stack.empty() && stack.peek() < nums[i]){
                last = stack.pop();
            }
            stack.push(nums[i]);
        }

        System.out.println(result);
        if (result.size()>0){
            return true;
        }

        return false;
    }
}
