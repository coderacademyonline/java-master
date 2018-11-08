package leetcode.array;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/10/31 21:38
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
       // int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1,1,2};
        removeDuplicates.removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int temp = nums[0];
        int j = 1;
        for (int i=1;i<nums.length;i++){
            if (nums[i] != temp){
                temp = nums[i];
                nums[j] = temp;
                j++;
            }else {
                length--;

            }
        }

        for (int i=0;i<length;i++){
            System.err.print(nums[i]+",");
        }
        return length;
    }
}
