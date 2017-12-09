package java1.algorithm.recursive;

import java.util.Scanner;

/**
 * 递归实现兔子产仔问题
 * 第一个月：1只
 * 第二个月：1只
 * 第三个月：2只
 * 第四个月：3只
 * 第五个月：5只
 * 第六个月：8只
 * 。。。
 * 第n个月：第n-1个月+第n-2个月
 * @author Administrator
 *
 */
public class Recursive {

	public static void main(String[] args) {
		System.out.println("请输入月份：");
	   Scanner scanner=new Scanner(System.in);
	   int month=scanner.nextInt();
       System.out.println(month+"月后兔子的总数为："+recursive(month));
	}

	/**
	 * 
	 * @param n 月份
	 * @return 兔子个数
	 */
	public static int recursive(int n){
		if (n==1) {
			return 1;
		}else if (n==2) {
			return 1;
		}else {
			return recursive(n-1)+recursive(n-2);
		}
	}
}
