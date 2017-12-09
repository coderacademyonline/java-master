package java1.algorithm.bisearch;

import java.util.Scanner;


/**
 * 折半查找
 * @author Administrator
 *
 */
public class Bisearch {

	static final int MAX_LEN=15;
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		long[] nums=new long[MAX_LEN];
		for (int i = 0; i < MAX_LEN; i++) {
			nums[i]=(long) (Math.random()*99);
		}
		System.out.println("排序前数组为：");
		for (long l : nums) {
			System.out.print(l+" ");
		}
		System.out.println("\n");
		quickSort(nums, 0, MAX_LEN-1);
		System.out.println("排序后的数组为：");
		for (long l : nums) {
			System.out.print(l+" ");
		}
		System.out.println("\n");
		System.out.println("请输入要查找的数：");
		long target=scanner.nextLong();
		int n=bisearch(nums, target, 0, MAX_LEN-1);
		System.out.println("您要找查找的数"+target+"，在第"+(n+1)+"个位置！");
	}
	
	public static void  quickSort(long[] num,int left,int right){
		if(left<right){
			int partition=partition(num, left, right);
			quickSort(num, left, partition-1);
			quickSort(num, partition+1,right);
		}
	}
	
	public static int partition(long[] num,int left,int right){
		long temp=num[left];
		while(left<right){
		
		while(left<right&&num[right]>=temp){
			right--;
		}
		swap(num, left, right);
		
		while(left<right&&num[left]<=temp){
			left++;
		}
		swap(num, left, right);
		}
		return left;
	}
	
	public static void swap(long[] num,int m,int n){
        long temp = num[m];
        num[m]=num[n];
        num[n]=temp;
    }
	
	public static int bisearch(long[] nums,long target,int low,int high){
		int mid=-1;
		while(low<=high){
			mid=(low+high)/2;
			if (target==nums[mid]) {
				return mid;
			}else if (target>nums[mid]) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return mid;
	}
}
