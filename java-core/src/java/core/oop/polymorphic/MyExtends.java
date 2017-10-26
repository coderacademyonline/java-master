package java.core.oop.polymorphic;

public class MyExtends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        E e=new F();
        F f=new F();
        e.show(f);
	}
  //this.show(O)    super.show(O)   this.show(super O)  super.show(super O)
}

class E{
	static String a;
	public void show(E e){
		System.out.println("this 代表 父类");
	}
}

class F extends E{
	public void show(E e){
		System.out.println("this 代表 子类");
	}
	
	public void show(F f){
		System.out.println("this 代表 子类1");
	}
}