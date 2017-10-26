package java.core.thread.join;

public class ThreadJoin {
	
  public static void main(String[] args) {
	    String threadName=Thread.currentThread().getName();
		System.out.println(threadName+"start。。。。");
		/*Thread1 thread1=new Thread1();
		Thread t1=new Thread(thread1,"thread1");
		
		Thread2 thread2=new Thread2(thread1);
		Thread t2=new Thread(thread2,"thread2");
		
		
		try {
			t1.start();
			Thread.sleep(2000);
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Thread3 thread3=new Thread3();
		Thread4 thread4=new Thread4(thread3);
		
		
		try {
			thread3.start();
			Thread.sleep(1000);
			thread4.start();
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}


class Thread1 implements Runnable{

	@Override
	public void run() {
		String threadName=Thread.currentThread().getName();
		System.out.println(threadName+" start。。。。");
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(threadName+" loop at "+i);
				Thread.sleep(1000);
			}
			System.out.println(threadName+" end 。。。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class Thread2 implements Runnable{

	public Thread1 thread1;
	
	public Thread2(Thread1 thread1) {
		this.thread1=thread1;
	}
	
	@Override
	public void run() {
		String threadName=Thread.currentThread().getName();
		System.out.println(threadName+" start。。。。");
		try {
			new Thread(thread1).join();
			System.out.println(threadName+" end。。。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class Thread3 extends Thread{

	@Override
	public void run() {
		String threadName=Thread.currentThread().getName();
		System.out.println(threadName+" start。。。。");
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(threadName+" loop at "+i);
				Thread.sleep(1000);
			}
			System.out.println(threadName+" end 。。。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread4 extends Thread{
	private Thread3 thread3;

	public Thread4(Thread3 thread3) {
		super();
		this.thread3 = thread3;
	}

	public Thread3 getThread3() {
		return thread3;
	}

	public void setThread3(Thread3 thread3) {
		this.thread3 = thread3;
	}
	
	@Override
	public void run() {
		String threadName=Thread.currentThread().getName();
		System.out.println(threadName+" start。。。。");
		try {
			thread3.join();
			System.out.println(threadName+" end。。。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}