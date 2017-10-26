package java.algorithm.sort;

/**
 * 快速排序
 * 基本思想是：
 * 1．先从数列中取出一个数作为基准数。
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 * @author zhaojw_420
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] num={5,4,7,12,76,30};
		QuickSort sort=new QuickSort();
		sort.qsort(num, 0, num.length-1);
		for (int i : num) {
			System.out.print(i+",");
		}
	}
	
	 public void qsort(int[] num,int left,int right){
	        if(left<right){
	            int partition = partition(num,left,right);//将num数组一分为二
	            qsort(num,left,partition-1); //对低字段表进行递归排
	            qsort(num,partition+1,right);//对高字段表进行递归排序
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
