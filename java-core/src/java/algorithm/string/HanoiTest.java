package java.algorithm.string;

import java.util.Scanner;

/**
 * 汉诺塔问题
 * 不考虑中转，只考虑起始柱子到目标柱子的移动
 * 记住始终一点：中间一个不管是啥柱子，都是中转，盘子移动只发生在起始到目标柱子
 * @author Administrator
 *
 */
public class HanoiTest {

	private static long count=0;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		hanoi(num, "A柱子", "B柱子", "C柱子");
		System.out.println(num+"个盘子，需要"+count+"次移动");
	}
	/**
	 * 
	 * @param num 汉诺塔个数
	 * @param start 起始的柱子
	 * @param transfer  中转柱子
	 * @param target  目标柱子
	 */
	static void hanoi(int num,String start,String transfer,String target){
		if(num==1){
			++count;
			//直接将盘从起始移到目标柱子
			System.out.println("第"+count+"次移动，\t从"+start+"移到"+target);
		}else {
			//将上面n-1个盘先移到中转的柱子上,相当于中转的就是目标柱子
			hanoi(num-1, start, target, transfer);
			//将起始柱子上的一个盘移到目标柱子
			hanoi(1, start, transfer,target);
			//将中转柱子上的n-1个盘移到目标柱子上
			hanoi(num-1, transfer,start, target);
			
		}
	}
}
