package java1.core.exception;


import java.util.Scanner;

/**
 * 自定义异常
 * @author zhaojw
 *
 */
public class MyException {

	public static void main(String[] args) {
		Division division=new Division();
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入被除数x：");
		int x=scanner.nextInt();
		System.out.println("请输入除数y：");
		int y=scanner.nextInt();
		try {
			int result=division.division(x, y);
			System.out.println(x+"除以"+y+"的结果为："+result);
		} catch (NumberException e) {
			e.printStackTrace();
		}
	}
}

class NumberException extends Exception{
	private static final long serialVersionUID = 1L;

	public NumberException(String message){
		super(message);
	}
}

class Division{
	public int division(int x,int y) throws NumberException{
		if (y<0) {
			throw new NumberException("输入的数是"+y+"，是一个负数，规定负数不能为除数。");
		}
		if (y==0) {
			throw new NumberException("输入的数是"+y+"，是零，规定零不能为除数。");
		}
		return x/y;
	}
}