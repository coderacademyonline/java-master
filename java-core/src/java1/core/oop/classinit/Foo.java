package java1.core.oop.classinit;


public class Foo {

	public static void main(String[] args) {
		Foo foo=new Foo();
		int a=99;
		foo.test1(a);
		System.out.println("经过test1方法后。值传递："+a);
		
		MyFoo mf=new MyFoo();
		foo.test2(mf);
		System.out.println("经过test1方法后。引用传递："+mf.mf);
	}
	
	public void test1(int a){
		a+=1;
	    System.out.println("值传递："+a);
	}
	
	public void test2(MyFoo mf){
		mf.mf=mf.mf+1;
		System.out.println("引用传递："+mf.mf);
	}
}

class MyFoo{
	int mf=99;
}