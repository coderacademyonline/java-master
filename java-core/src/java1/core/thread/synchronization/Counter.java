package java1.core.thread.synchronization;

public class Counter {

	public static int count=0;//错误使用。因为没有锁的支持，volatile的修改不能依赖于当前值，当前值可能在其他线程中被修改。
	
	public static void inc(){
		synchronized(Counter.class){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		System.out.println(Thread.currentThread().getName()+"，此时的运行结果count值："+count);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       for (int i = 0; i < 100; i++) {
    	  Thread thread= new Thread(new Runnable() {
   			
   			@Override
   			public void run() {
   				// TODO Auto-generated method stub
   				Counter.inc();
   			}
   		},"线程"+i);
    	  thread.start();
    	  try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       
		System.out.println("运行结果为："+Counter.count);
	}

}
