package java1.algorithm.sort;

public class QuickSort1 {

	public static void main(String[] args) {
		long[] nums=new long[10];
		
		for (int i = 0; i < 10; i++) {
			nums[i]=(long) (Math.random()*99);
		}
		/*System.out.print("起始数组为：[");
		for (long l : nums) {
			System.err.print(l+",");
		}
		System.out.print("]");*/
		quickSort(nums, 0, nums.length-1);
		
		System.out.println();
		System.out.print("排序后数组为:[");
		for (long l : nums) {
			System.err.print(l+",");
		}
		System.out.print("]");
	}
	
	static void quickSort(long[] nums,int left,int right){
		if (right-left>0) {
			long point=nums[right];
			//获取切入点，同时对数组进行划分
		   int partition=partition(nums, left, right, point);
		    //左边排序
		   quickSort(nums, left, partition-1);
		   //右边排序
		   quickSort(nums, partition+1,right);
		}
	}
	
	static int partition(long[] nums,int left,int right,long point){
		int ltemp=left-1;
		int rtemp=right;
		while(true){
			//循环，将比关键字小的留在左边
			while(ltemp<rtemp&&nums[++ltemp]<point); //两个while循环的目的是如左边有比point大的，将发生移动，若有肯定会跳出循环，执行下面的交换
			
			//循环，将比关键字大的留在右边
			while(rtemp>ltemp&&nums[--rtemp]>point); //两个while循环的目的是如右边有比point小的，将发生移动，若有肯定会跳出循环，执行下面的交换
			
			if (ltemp>=rtemp) {
				break;
			}else {
				long temp=nums[ltemp];
				nums[ltemp]=nums[rtemp];
				nums[rtemp]=temp;
			}
		}
	    //当关键字和当前的leftPtr所指的这一个进行交换
		long temp=nums[ltemp];
		nums[ltemp]=nums[right];
		nums[right]=temp;
		return ltemp;
	}
}
