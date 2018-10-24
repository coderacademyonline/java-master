package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     leetcode第一题
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 例如：
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/11 17:48
 */
public class TwoSum {

    public static void main(String[] args){
        int[] nums = {-1,-2,-3,-4,4};
        List<int[]> result = TwoSum.twoSum(nums,0);
        System.out.println("找到结果集：");
        for(int i=1;i<=result.size();i++){
            int[] index = result.get(i-1);
            System.out.println("第"+i+"个：["+index[0]+","+index[1]+"]");
        }
    }

    /**
     * 此方法时间复杂度是O(n*n)  n的平方
     * @param nums
     * @param target
     * @return
     */
    public static List<int[]> twoSum(int[] nums,int target){
        List<int[]> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if (nums[i]+nums[j]==target){
                        int[] index={i,j};
                        result.add(index);
                        System.out.print("["+i+","+j+"]");
                    }
                }
        }
        return result;
    }

    /**
     * 题给出假如数组中只有一个符合情况，所以对一个map中，如果这两个值加起来刚好等于target，那么target-数组中的某一个元素后的值一定存在于这个map的key中
     * 此法时间复杂度为O(n),两个循环方法，都循环了一遍即为O(2*n) = O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
       return new int[]{};
    }

    /**
     * 思路同上
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
