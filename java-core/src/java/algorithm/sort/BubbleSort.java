package java.algorithm.sort;

/**
 * 冒泡排序
 * 设数组长度为N。
 * 比较相邻的前后二个数据，如果前面数据大于后面的数据，就将二个数据交换。
 * 这样对数组的第0个数据到N-1个数据进行一次遍历后，最大的一个数据就“沉”到数组第N-1个位置。
 * N=N-1，如果N不为0就重复前面二步，否则排序完成。
 * @author zhaojw_420
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]={1,54,6,3,78,34,12,45,56,100}; 
		int length=a.length;
		BubbleSort sort=new BubbleSort();
		sort.bubbleSort3(a,length);
	}

	
	public void bubbleSort1(int[] a,int length){
		
		for (int i = 0; i < length; i++) {
			for (int j =i+ 1; j < length; j++) {
				if(a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			
			System.out.println("第"+i+"次数组排序结果为：");
			for (int k = 0; k <length; k++) {
				System.out.print(" "+a[k]);
			}
			System.out.print("\n");
		}
		
		for (int i : a) {
			System.err.print(i+",");
		}
	}
	
	/**
	 * 对其进行优化，设置一个标志，如果这一趟发生了交换，则为true，否则为false。
	 * 明显如果有一趟没有发生交换，说明排序已经完成。
	 * @param a
	 * @param length
	 */
	public void bubbleSort2(int[] a,int length){
		boolean flag=true;

		while(flag&&length>0){
			flag=false;
			for (int j = 1; j < length; j++) {
				if(a[j-1]>a[j]){
					int temp=a[j-1];
					a[j-1]=a[j];
					a[j]=temp;
					flag=true;
				}
			}
			
			length--;
		}
		
		for (int i : a) {
			System.err.print(i+",");
		}
	}
	
	/**
	 * 如果有100个数的数组，仅前面10个无序，后面90个都已排好序且都大于前面10个数字，那么在第一趟遍历后，
	 * 最后发生交换的位置必定小于10，且这个位置之后的数据必定已经有序了，记录下这位置，
	 * 第二次只要从数组头部遍历到这个位置就可以了。
	 * @param a
	 * @param length
	 */
	public void bubbleSort3(int[] a,int length){
		
		int j, k;  
	    int flag;  
	      
	    flag = length;  
	    while (flag > 0)  
	    {  
	        k = flag;  
	        flag = 0;  
	        for (j = 1; j < k; j++)    //随着交换位置后面的排序号，flag是慢慢变小的，直到交换位置等于0，说明已排好顺序，然后退出循环
	            if (a[j - 1] > a[j])  
	            {  
	            	int temp=a[j-1];
					a[j-1]=a[j];
					a[j]=temp;
	                flag = j;  
	            }  
	    }  
		
		for (int i : a) {
			System.err.print(i+",");
		}
	}
}
