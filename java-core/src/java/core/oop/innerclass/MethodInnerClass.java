package java.core.oop.innerclass;

/**
 * 方法内部类（局部内部类）
 * 在方法体或语句块（包括方法、构造方法、局部块或静态初始化块）内部定义的类成为局部内部类。
 * 局部内部类不能加任何访问修饰符，因为它只对局部块有效。
 * 1.局部内部类只在方法体中有效，就想定义的局部变量一样，在定义的方法体外不能创建局部内部类的对象
 * 2.在方法内部定义类时，应注意以下问题：
 *  (1).方法定义局部内部类同方法定义局部变量一样，不能使用private、protected、public等访问修饰说明符修饰，也不能使用static修饰，但可以使用final和   abstract修饰
 *  (2).方法中的内部类可以访问外部类成员。对于方法的参数和局部变量，必须有final修饰才可以访问(JDK 1.8以后不需要！)。
 *  (3).static方法中定义的内部类可以访问外部类定义的static成员
 * @author zhaojw_420
 *
 */
public class MethodInnerClass {
	
	private String str="我是外部类的成员变量";
	private String outerStr="我是外部类的成员变量";
	
	public void outerMethod() {
		System.out.println("我是外部类地方法");
	}
	
	public void  method(String s) {
		class InnerClass{
			private String str="我是方法内部类的成员变量";
			public void  print() {
				System.out.println("我是方法内部类地方法,访问方法参数："+s);
				System.out.println("我是方法内部类地方法,访问内部类的成员变量："+str);
				System.out.println("我是方法内部类地方法,访问外部类的成员变量："+outerStr);
				System.out.println("我是方法内部类地方法,访问外部类与内部类同名的成员变量："+MethodInnerClass.this.str);
			}
		}
		 new InnerClass().print();
	}
	
	public static void main(String[] args) {
		MethodInnerClass out=new MethodInnerClass();
		out.method("成员内部类");
		
	}
}
