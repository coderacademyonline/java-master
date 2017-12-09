package java1.algorithm.sort;


/**
 * 插入排序
 * @author zhaojw
 *
 *基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 
 *好顺序的，现在要把第n 个数插到前面的有序数中，使得这 n个数 
 *也是排好顺序的。如此反复循环，直到全部排好顺序。 
 */
public class InsertionSort {

	public void insertSort(){
		//int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51}; 
		int[] a={118,101,90,127,112};
		int temp=0;
		for (int i = 1; i < a.length; i++) {
			temp=a[i];
			int j=i-1;
			 while(j>=0&&temp<a[j]){   
				   a[j+1]=a[j];  //将大于temp 的值整体后移一个单位   
				   j--;       //每次减1，然后判断是否还需要移动，如果不需要那么此时减1的位置就是temp的插入位置
				 }   
			 a[j+1]=temp;  //跳出循环之前，j已经移动到插入位置的前一个位置了。  
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		InsertionSort sort=new InsertionSort();
		sort.insertSort();
	}
}
