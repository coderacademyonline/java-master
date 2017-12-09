package java1.algorithm.exhaustive;

/**
 * 穷举算法实现鸡兔同笼
 * 鸡+兔=35只
 * 脚=94只
 * @author Administrator
 *
 */
public class Exhaustive {

	public static void main(String[] args) {
		int chicken;//鸡
		int rabbit;//兔
		for (chicken = 0; chicken <=35; chicken++) {
			rabbit=35-chicken;
			if ((2*chicken+rabbit*4)==94) {
				System.out.println("鸡的数量为："+chicken+",兔子的数量为："+rabbit);
			}
		}
	}
}
