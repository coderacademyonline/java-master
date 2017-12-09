package java1.algorithm.string;

import java.util.Scanner;

/**
 * 猴子吃桃
 * 可以采用倒推的思想去计算：
 * 假如第一天有一个桃子 eatPeach(1)=1 
 * 那么第二天跟第一天的桃子的关系为：即 eatPeach(1)=eatPeach(2)-(eatPeach(2)/2+1)=eatPeach(2)/2-1
 * 第三天跟第二天的桃子的关系为：eatPeach(2)=eatPeach(3)-(eatPeach(3)/2+1)=eatPeach(3)/2-1
 * 那么第n天与第n-1天的桃子的关系为：eatPeach(n-1)=eatPeach(n)-(eatPeach(n)/2+1)=eatPeach(n)/2-1
 * 即eatPeach(n)=2eatPeach(n-1)+2
 * @author Administrator
 *
 */
public class MonkeyTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scanner=new Scanner(System.in);
      int day=scanner.nextInt();
      System.out.println("猴子，第"+day+"天吃的桃子为："+eatPeach(day));
	}

	static int eatPeach(int day){
		if(day==1){
			return 1;
		}else {
			return 2*eatPeach(day-1)+2;
		}
	}
	
}
