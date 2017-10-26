package java.core.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 10, 200, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(5));
		for (int i = 0; i <15; i++) {
			MyPool myPool=new MyPool(i);
			executor.execute(myPool);
			System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目"+executor.getQueue().size()+"，已执行完的任务数目："+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}
}

class MyPool implements Runnable{

	private int poolNum;
	
	public MyPool(int poolNum) {
		super();
		this.poolNum = poolNum;
	}


	public int getPoolNum() {
		return poolNum;
	}


	public void setPoolNum(int poolNum) {
		this.poolNum = poolNum;
	}


	@Override
	public void run() {
		System.out.println("正在执行poolNum："+poolNum);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("pool "+poolNum+"执行完毕");
	}
	
}