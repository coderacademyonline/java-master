package java1.algorithm.array;

/**
 * 数组中有一个数字出现的次数大于这个数组的长度的一半，找出这个数
 * @author zhaojw_420
 *
 */
public class MoreThanHarf {

	public static void main(String[] args) {
		int[] num = {1,2,2,2,2,2,2,4,2,4,6,4,2,6,8,2,7,7};
        System.out.println(moreThanHaft(num));
	}
	
	public static int moreThanHaft(int[] num){
		int result=-1;//返回的结果
		int count=0;//某个数字出现的次数，与前一次相等则加1，否则减1
		
		for (int i = 0; i < num.length; i++) {
			if (count==0) {
				result=num[i];
				count++;
			}else {
				if(result==num[i]){
					count++;
				}else {
					count--;
				}
			}
		}
		return result;
	}
}
