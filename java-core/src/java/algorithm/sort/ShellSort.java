package java.algorithm.sort;

/**
 * 希尔排序
 * @author zhaojw
 * 基本思想：算法先将要排序的一组数按某个增量 d（n/2,n为要排序数的个数）分成若
 * 干组，每组中记录的下标相差 d.对每组中全部元素进行直接插入排序，然后再用一个较小
 * 的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到 1 时，进行直接
 * 插入排序后，排序完成。
 *
 */
public class ShellSort {

	/**
	 * 按照定义来的代码
	 */
	public void shellSort(){
		
		 int a[]={1,54,6,3,78,34,12,45,56,100}; 
		 int n=a.length;
		 int i, j, gap;  
		  
		 for (gap = n / 2; gap > 0; gap /= 2) //步长  
		        for (i = 0; i < gap; i++)        //直接插入排序  
		        {  
		            for (j = i + gap; j < n; j += gap)   
		                if (a[j] < a[j - gap])  
		                {  
		                    int temp = a[j];  
		                    int k = j - gap;  
		                    while (k >= 0 && a[k] > temp)  
		                    {  
		                        a[k + gap] = a[k];  
		                        k -= gap;  
		                    }  
		                    a[k + gap] = temp;  
		                }  
		        }  
		 for (int k : a) {
			System.err.print(k+",");
		}
	}
	
	/**
	 * 从1B开始，先和1A比较，然后取2B与2A比较，再取1C与前面自己组内的数据比较…….。
	 * 这种每次从数组第gap个元素开始，每个元素与自己组内的数据进行直接插入排序显然也是正确的。
	 */
	public void sort(){
		int a[]={49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
		int n=a.length;
		int gap;
		 for (gap = n / 2; gap > 0; gap /= 2){ //步长  
				for (int i = gap; i < n; i++) {//从数组第gap个元素开始 
				if (a[i] < a[i - gap]){//每个元素与自己组内的数据进行直接插入排序  
					int temp=a[i];
					int k=i-gap;
					while(k>=0&&temp<a[k]){
						a[k+gap]=a[k];
						k-=gap;
					}
					a[k+gap]=temp;
				}
		 }
			
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
	}

	public static void main(String[] args) {
		ShellSort shellSort=new ShellSort();
		shellSort.shellSort();
	}
}
