package java.algorithm.recursive;

import java.util.Scanner;

/**
 * 递归求解阶乘
 * n!=n*(n-1)*(n-2)......2*1
 * @author Administrator
 *
 */
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入要求阶乘的数：");
		long n=scanner.nextLong();
		System.out.println(n+"的阶乘为："+factorial(n));
	}

	public static long factorial(long n){
		if (n<=1) {
			return 1;
		}else {
			return n*factorial(n-1);
		}
	}
}
