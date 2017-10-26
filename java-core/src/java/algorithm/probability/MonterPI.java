package java.algorithm.probability;

import java.util.Scanner;

public class MonterPI {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("蒙特卡洛概率算法计算PI");
		System.out.println("请输入点的数量：");
		long n=scanner.nextLong();
		double PI=monterPI(n);
		System.out.println("圆周率为："+PI);

	}

	public static double monterPI(long n){
		int sum=0;
		double x=0.0;
		double y=0.0;
		for (int i = 0; i < n; i++) {
			x=Math.random();
			y=Math.random();
			if ((x*x+y*y)<=1) {
				sum++;
			}
		}
		
		double PI=4.0*sum/n;
		return PI;
	}
}
