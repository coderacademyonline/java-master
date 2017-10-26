package java.core.thread.local;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ThreadLocalTest2 {

	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				
				public void run() {
					int data=new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" has put data:"+data);
					MyThreadScopeData.getThreadIntance().setName("name"+data);
					MyThreadScopeData.getThreadIntance().setAge(data);		
					new A().get();
					new B().get();
					
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			MyThreadScopeData myData=MyThreadScopeData.getThreadIntance();
			System.out.println("A from "+Thread.currentThread().getName()+"  getMyData:"+myData.getName()+" ,"+myData.getAge());
		}
	}
	
	static class B{
		public void get(){
			MyThreadScopeData myData=MyThreadScopeData.getThreadIntance();
			System.out.println("B from "+Thread.currentThread().getName()+"  getMyData:"+myData.getName()+" ,"+myData.getAge());
		}
	}
}

class MyThreadScopeData{
	
    private MyThreadScopeData(){
		
	}
	// 单例模式
	private static ThreadLocal<MyThreadScopeData> myData=new ThreadLocal<MyThreadScopeData>();
	
	public static MyThreadScopeData getThreadIntance(){
		 MyThreadScopeData intance =myData.get();
		if(intance==null){
			intance=new MyThreadScopeData();
			myData.set(intance);
		}
		return intance;
	}
	
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}