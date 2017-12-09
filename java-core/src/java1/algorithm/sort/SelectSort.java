package java1.algorithm.sort;

/**
 * 选择排序
 * 基本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * @author zhaojw_420
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int a[]={49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
		selectSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static void selectSort(int[] numbers)
    {
    int size = numbers.length; //数组长度
    int temp = 0 ; //中间变量
    
    for(int i = 0 ; i < size ; i++)
    {
        int k = i;   //待确定的位置,一直去找下一个最小的数
        //选择出应该在第i个位置的数
        for(int j = size -1 ; j > i ; j--)
        {
        if(numbers[j] < numbers[k])
        {
            k = j;
        }
        }
        //交换两个数
        temp = numbers[i];
        numbers[i] = numbers[k];
        numbers[k] = temp;
    }
    }
}
