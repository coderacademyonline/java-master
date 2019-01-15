package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/24 17:05
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        ThreeNumSum threeNumSum = new ThreeNumSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeNumSum.threeSum(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = this.theFirstSolution(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>(result);
        result.clear();
        set.forEach(v->{
            result.add(v);
        });
        return result;
    }

    public List<List<Integer>> theFirstSolution(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int length = nums.length;
        // 先排序一下
        this.qsort(nums,0,length-1);

        Set<Integer> set = new HashSet<>(16);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i>=1 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                int target = (nums[i] + nums[j]) * (-1);
                if (set.contains(target)) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(target);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                }else{
                    set.add(nums[i]);
                }
            }
        }
        return result;
    }


    public void qsort(int[] num,int left,int right){
        if(left<right){
            //将num数组一分为二
            int partition = partition(num,left,right);
            //对低字段表进行递归排
            qsort(num,left,partition-1);
            //对高字段表进行递归排序
            qsort(num,partition+1,right);
        }
    }

    public int partition(int[] num,int left,int right){
        int partition = num[left];
        while(left<right){
            //从左往右找小于partition的数来填num[left]
            while(left<right && num[right]>=partition){
                right--;
            }
            swap(num,left,right);
            //从左往右找大于partition的数来填num[right]
            while(left<right && num[left]<=partition){
                left++;
            }
            swap(num,left,right);
        }

        return left;
    }

    public void swap(int[] num,int m,int n){
        int temp = num[m];
        num[m]=num[n];
        num[n]=temp;
    }
}
