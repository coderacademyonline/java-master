package java1.core.oop.innerclass;


/**
 * 静态嵌套类
 * 与类的其他成员相似，可以用static修饰内部类，这样的类称为静态内部类。
 * 静态内部类与静态内部方法相似，只能访问外部类的static成员，不能直接访问外部类的实例变量，
 * 对于实例方法或者非静态变量，只有通过对象引用才能访问。
 * 由于static内部类不具有任何对外部类实例的引用，因此static内部类中不能使用this关键字来访问外部类中的实例成员，
 * 但是可以访问外部类中的static成员。这与一般类的static方法想通
 * @author zhaojw_420
 *
 */
public class StaticNestedClass {

	private static String str="我是外部类的静态变量";
	
	private String outStr="我是外部类的非静态变量";
	
	public static class InnerClass{
		private  String str="我说是静态内部类的变量";
		
		public void innerMethod() {
			System.out.println("访问外部类："+StaticNestedClass.str);
			// 对于实例方法或者非静态变量，只有通过对象引用才能访问。
			System.out.println("访问外部类非静态成员变量："+new StaticNestedClass().outStr);
			System.out.println("访问内部类："+str);
		}
		
	}
	
	public static void main(String[] args) {
		//因为内部类被静态化，因此StaticNestedClass.InnerClass可以当做一个整体看，可以直接new 出内部类的对象（通过类名访问static，生不生成外部类对象都没关系）
		InnerClass innerClass=new InnerClass();
		innerClass.innerMethod();
	}
}
