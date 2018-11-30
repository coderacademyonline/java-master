package leetcode.str;

/**
 * <p>
 *     给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *     如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * </p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2018/11/10 23:02
 */
public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = {1};
        int target = 1;
        System.out.println("应插入的位置："+searchInsert.searchInsert(nums,target));
    }

    public int searchInsert(int[] nums, int target) {

        int length = nums.length;
        if (length == 1){
            if (nums[0] < target){
                return 1;
            }
        }
        for (int i=0;i<length-1;i++){
            if (nums[i] == target){
                return i;
            }
            if (nums[i] < target && nums[i+1]>=target){
                return i+1;
            }

            if (nums[length-1] < target){
                return length;
            }
        }
        return 0;
    }

    /**
     * 循环二分查找法
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int middle = (start+end)/2;
            if (nums[middle] == target){
                return middle;
            }else {
                if (nums[middle] < target){
                    start = middle+1;
                }else {
                    end = middle -1;
                }

            }

        }
        return -1;
    }

}
