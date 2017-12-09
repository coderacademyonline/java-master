package java1.algorithm.conquer;

import java.util.Scanner;

/**
 * 分治法求解硬币中的假币问题
 * 一个袋子里有n个硬币，其中一枚是假币，并且假币和真币一模一样，
 * 仅凭肉眼无法区分，仅知道假币比真币轻一些，请问如何查找到假币？
 * 
 * 思想：将这n个硬币分成两等份，然后放到天平的两端，则假币在较轻的那一端；
 * 然后将较轻的那一端的硬币再分成2等份，然后再放到天平的两端进行比较，假币还是在较轻的那一段；
 * 直到最后只剩下两个硬币了，分别放到天平的两端，轻的哪一个就是假币。
 * 当然，最后也可能剩下3个硬币，我们可以将这3个硬币中任意拿出来一个，然后将剩下的两个放到天平的两端，如果天平是平的，则说明拿出来的那个硬币就是假币；
 * 如果天平不是平的，则轻的那一端是假币。
 * 
 * 先分组，在用递归方法
 * @author Administrator
 *
 */
public class FalseCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		System.out.println("分治法求解假硬币问题！");
		System.out.println("请输入硬币个数：");
		int n=scanner.nextInt();
		int[] coin=new int[n];
		System.out.println("请输入具体的硬币重量（2代表真硬币，1代表假硬币）:");
		for (int i = 0; i < n; i++) {
			System.out.print("请输入第"+(i+1)+"个硬币：");
			coin[i]=scanner.nextInt();
			
		}
		int target=falseCoin(coin, 0, n-1);
		System.out.println("在上述"+n+"个硬币中，第"+target+"个是假币！");
	}

	/**
	 * 分组
	 * @param coin 硬币数组
	 * @param start 数组分组的起始位置
	 * @param end   数组分组的结束位置
	 * @return
	 */
	static int falseCoin(int[] coin,int start,int end){
		int sum1=0;//前段硬币的重量和
		int sum2=0;//后段硬币的重量和
		int sum3=0;//若硬币个数为奇数，则为正中间那个硬币的重量
		int target=0;//假币的下标
		
		/**
		 * 若剩下最后三个硬币
		 */
		if (start+1==end) {
			if (coin[start]<coin[end]) {
				target=start+1;
				return target;
			}else {
				target=end+1;
				return target;
			}
		}
		
		/**
		 * 若硬币个数为偶数
		 */
		int separate=start+(end-start)/2;
		if ((end-start+1)%2==0) {
			for (int i = start; i <=separate ; i++) {
				sum1+=coin[i];    //前半段和
			}
			for (int i = separate+1; i <=end; i++) {
				sum2+=coin[i];   //后半段和
			}
			
			//比较两段的重量，轻的一端继续递归调用falsecoin方法
			if (sum1<sum2) {
				target=falseCoin(coin, 0, separate);
				return target;
			}else if(sum1>sum2){
				target=falseCoin(coin, separate+1, end);
				return target;
			}
		}else {
			//硬币个数是偶数
			for (int i = start; i <=separate-1; i++) {
				sum1+=coin[i];    //前半段和
			}
			for (int i = separate+1; i <=end; i++) {
				sum2+=coin[i];   //后半段和
			}
			sum3=coin[separate];
			//比较两段的重量，轻的一端继续递归调用falsecoin方法
			if (sum1<sum2) {
				target=falseCoin(coin, 0, separate-1);
				return target;
			}else if(sum1>sum2){
				target=falseCoin(coin, separate+1, end);
				return target;
			}
			//正好中间那个是假币
			if (sum1+sum3==sum2+sum3) {
				target=separate+1;
				return target;
			}
		}
		return target;
	}
}
