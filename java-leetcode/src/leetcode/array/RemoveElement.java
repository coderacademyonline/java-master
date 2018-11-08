package leetcode.array;

/**
 * <p>
 *      给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/8 15:23
 */
public class RemoveElement {

    public static void main(String[] args){
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int length = removeElement.removeElement(nums,2);
        System.out.println("长度："+length);
        for(int i=0;i<length;i++){
            System.out.print(nums[i]+",");
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null){
            return 0;
        }
        int length = nums.length;
        int j = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i] != val){
                nums[j]  = nums[i];
                j++;
            }else{
                length--;
            }
        }
        return length;
    }
}
