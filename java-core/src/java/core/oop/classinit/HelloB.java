package java.core.oop.classinit;
/**
 * 
 * @author zhaojw
 *
 */
public class HelloB extends HelloA{

	public HelloB(){
		System.out.println("HelloB");
	}
	
	{
		System.out.println("I am  HelloB.class");
	}
	
	static{
		System.out.println("Static HelloB ");
	}
	
	public static void main(String[] args) {
		System.out.println("-------main start-------");
		new HelloB();
		System.out.println("-------main end-------");
	}
}

class HelloA{
	public HelloA(){
		System.out.println("HelloA");
	}
	
	{
		System.out.println("I am  HelloA.class");
	}
	
	static{
		System.out.println("Static HelloA ");
	}
}