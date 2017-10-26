package java.core.thread.boundedbuffer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedThread {

	public static void main(String[] args) {
		SynchronizedThread sThread=new SynchronizedThread();
		sThread.useThread();
		
	}

   public void useThread(){
	   Bank bank=new Bank();
	   SaveBankThread savebankThread=new SaveBankThread(bank);
		
		Thread thread1=new Thread(savebankThread);
		thread1.start();
		
		RemoveBankThread removeBankThread=new RemoveBankThread(bank);
		
		Thread thread2=new Thread(removeBankThread);
		thread2.start();
   }
}
class Bank{
	/**
	 * volatile实现
	 */
	private  int count=0;
	/**
	 * 使用可重入锁
	 */
	private Lock lock=new ReentrantLock();
	
	public void getCount(){
		System.out.println("账户余额为："+count);
	}
	/**
	 * 同步方法实现存钱
	 * @param money
	 */
	public void save(int money){
		lock.lock();
		try {
			count+=money;
			System.out.println(System.currentTimeMillis()+"存进："+money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();//释放锁
		}
	}
	/**
	 * 同步代码块实现取钱
	 * @param money
	 */
	public  void remove(int money){
		if (count-money<0) {
			System.err.println("余额不足。");
			return;
		}
		    lock.lock();
			try {
				count-=money;
				System.err.println(System.currentTimeMillis()+"取出："+money);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		
	}
}

class Bank1{
	
	private static ThreadLocal<Integer> count=new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	
	
	public void getCount(){
		System.out.println("账户余额为："+count.get());
	}
	/**
	 * 局部变量实现存钱
	 * @param money
	 */
	public void save(int money){
		count.set(count.get()+money);
		System.out.println(System.currentTimeMillis()+"存进出："+money);
	}
	/**
	 * 局部变量实现取钱
	 * @param money
	 */
	public  void remove(int money){
		if (count.get()-money<0) {
			System.err.println("余额不足。");
			return;
		}
		count.set(count.get()-money);
		System.err.println(System.currentTimeMillis()+"取出："+money);
	}
}
class SaveBankThread implements Runnable{

	private Bank bank;
	
	public SaveBankThread(Bank bank){
		this.bank=bank;
	}
	
	public void run() {
		   while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bank.save(100);
			bank.getCount();
			System.out.println("\n"); 
		   }
	}
 }

class RemoveBankThread implements Runnable{

	private Bank bank;
	
	public RemoveBankThread(Bank bank){
		this.bank=bank;
	}
	public void run() {
		
		 while(true){
			
			bank.remove(100);
			bank.getCount();
			System.out.println("\n"); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}