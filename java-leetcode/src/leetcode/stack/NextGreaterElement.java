package leetcode.stack;

import java.util.*;

/**
 * <p>
 *     leetcode第496题：
 *     给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
        nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

 示例：
 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]
 解释:
 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/1/28 11:25
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        // 使用一个map，key存储num2的元素，value存储num2的元素的下一个元素
        int length = nums2.length;
        Map<Integer,Integer> numsMap = new HashMap<>(length);
        for(int i=0;i<length;i++){
            numsMap.put(nums2[i],this.getNextLarger(nums2,i,nums2[i]));
        }
        // 循环遍历num1，从map中查找
        for(int i=0;i<nums1.length;i++){
            Integer nums2Value = numsMap.get(nums1[i]);
            result[i] = nums2Value;
        }
        return result;
    }

    /**
     * 获取nums2的下一个比他大的元素
     * @param nums
     * @return
     */
    public int getNextLarger(int[] nums,int start,int target){
        for (int i=start+1;i<nums.length;i++){
            if (nums[i] > target){
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        NextGreaterElement main = new NextGreaterElement();
        int[] nums1= {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};

        int[] result = main.nextGreaterElement(nums1,nums2);
        for(Integer r:result){
            System.out.println(r);
        }
    }
}
