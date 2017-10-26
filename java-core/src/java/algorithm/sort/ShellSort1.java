package java.algorithm.sort;

/**
 * 希尔排序的优点：加大插入排序中元素之间的间隔，并对这些间隔的元素进行插入排序，从而使得数据可以大幅度的移动。
 * 当完成间隔的排序后，希尔排序会减少数据的间隔在进行排序，一次进行下去
 * 
 * 间隔的计算：间隔h的初始值为1.通过h=3*h+1 来计算循环，直到该间隔大于数组的大小时停止。最大间隔为不大于数组大小的最大值。
 * 间隔的减少：可以通过公式：；h=(h-1)/3计算
 * @author Administrator
 *
 */
public class ShellSort1 {

	public static void main(String[] args) {
		long[] nums={22,12,5,23,17,10,67};
        shellSort(nums);
	}
	
	static void shellSort(long[] nums){
		//计算最大间隔
		int h=1;
		
	    while(h<nums.length/3){
	    	h=h * 3 +1;
	    }
	    
	    while(h>0){
	    	//进行插入排序
	    	long temp=0;
	    	for (int i = h; i < nums.length; i++) { 
	    		temp=nums[i];
				int j=i;
				while(j>h-1&&nums[j-h]>temp){  //h是大于等于1的，，h-1>=0，，j>h-1
					nums[j]=nums[j-h];//将大于temp 的值整体后移一个单位   
					j-=h;//每次减h，然后判断是否还需要移动，如果不需要那么此时减h的位置就是temp的插入位置
				}
				
				nums[j]=temp;//此时j的位置就是temp的插入位置
			}
	    	h=(h-1)/3;
	    }
	    
	    for (long l : nums) {
	    	System.err.print(l+"\t");
		}
		
	}

}
