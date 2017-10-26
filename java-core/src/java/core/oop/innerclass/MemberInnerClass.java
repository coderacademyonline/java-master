package java.core.oop.innerclass;

/**
 * 成员内部类
 * 
 *1.成员内部类中的方法可以直接使用外部类的实例变量和实例方法。
 *2.在成员内部类中可以直接用内部类创建对象
 *3.成员内部类没有用static修饰且定义在在外部类类体中。
 * @author zhaojw_420
 *
 */
public class MemberInnerClass {

	private String str="我是外部类的成员变量";
	
	public void outerMethod() {
		System.out.println("我是外部类的方法");
	}
	
	class InnerClass{
		private String str="我是内部类的成员变量";
		
		public void innerMethod() {
			System.out.println("内部类的成员变量："+this.str);
			outerMethod();//访问外部类方法
			System.out.println("内部类再次访问外部类的成员变量："+MemberInnerClass.this.str);
		}
	}
	
	public InnerClass makeInnerClass() {
		//在外部类方法中创建内部类实例
		InnerClass innerClass=new InnerClass();
		return innerClass;
	}
	
	public static void main(String[] args) {
		MemberInnerClass outerClass=new MemberInnerClass();
		//成员内部类需要通过外部类的实例才能创建对象，与实例变量需要通过对象来访问相似
		//MemberInnerClass.InnerClass innerClass  =outerClass.makeInnerClass();
		//1.开头的MemberInnerClass是为了标明需要生成的内部类对象在哪个外部类当中
         //2.必须先有外部类的对象才能生成内部类的对象，因为内部类的作用就是为了访问外部类中的成员变量
		InnerClass innerClass = outerClass.new InnerClass();
		innerClass.innerMethod();
		
	}
}
