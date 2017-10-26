package java.core.oop.polymorphic;

/**
 * 
 * 当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，
 * 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法，
 * 但是它仍然要根据继承链中方法调用的优先级来确认方法
 * 
 * 其实在继承链中对象方法的调用存在一个优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 * @author Administrator
 *
 */
public class Polymorphic {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println("1--" + a1.show(b));//B继承了A,相当于传进去的是A，  A and A  第三级。。。
		System.out.println("2--" + a1.show(c));//C继承了B。B继承了A      A and A   第三级。。
		System.out.println("3--" + a1.show(d)); ///  A and D   第一级。。
		
		System.out.println("4--" + a2.show(b));//引用是A，所以this代表A对象。  B and A   
		System.out.println("5--" + a2.show(c));//  B and A   在第三级时，确定了要调用A中的show(A obj)的方法，但是，由于动态连接的问题，最终却调用了子类重写的方法
		System.out.println("6--" + a2.show(d));// A and D
		
		System.out.println("7--" + b.show(b)); //B and B
		System.out.println("8--" + b.show(c)); //  B and B
		System.out.println("9--" + b.show(d)); // A and D
	}
}

class A {
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}
}

class B extends A {
	public String show(B obj) {
		return ("B and B");
	}

	public String show(A obj) {
		return ("B and A");
	}
	
/*	public String show(D obj) {
		return ("B and D");
	}*/
}

class C extends B {
}

class D extends B {
}