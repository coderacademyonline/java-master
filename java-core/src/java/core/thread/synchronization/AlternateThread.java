package java.core.thread.synchronization;

/**
 * 子线程循环10次，主线程接着循环100次，如此循环50次的问题
 * @author zhaojw_420
 *
 */
public class AlternateThread {

	public static void main(String[] args) {
		final Bussies bussies=new Bussies();
		MainThread mainThread=new MainThread(bussies);
		SubThread subThread=new SubThread(bussies);
		Thread main=new Thread(mainThread,"主线程");
		Thread sub=new Thread(subThread,"子线程");
		main.start();
		sub.start();
	}
}

class Bussies{
	private boolean flage=true; //flage为true时打印主线程，为false时打印子线程
	
	public void main(){
		
		synchronized(this){
		while (!flage) {
			try {
				this.wait(); //为false时等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		for (int i = 0; i < 100; i++) {
			//System.err.println("<<<<main>>>>>");
			System.out.println(Thread.currentThread().getName()+"执行了第"+(i+1)+"次");
		}
		flage=false;
		this.notifyAll();
		}
	}
	
	public void sub(){
		synchronized(this){
			while (flage) {
			try {
				this.wait();//如果为true则等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()+"执行了第"+(i+1)+"次");
			}
			flage=true;
			this.notifyAll();
		}
	}
}

//主线程
class MainThread implements Runnable{

	private Bussies bussies;
	public MainThread(Bussies bussies) {
		this.bussies = bussies;
	}
	public Bussies getBussies() {
		return bussies;
	}
	public void setBussies(Bussies bussies) {
		this.bussies = bussies;
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			bussies.main();
		}
	}

}
//子线程
class SubThread implements Runnable{
	
	private Bussies bussies;
	
	public SubThread(Bussies bussies) {
		this.bussies = bussies;
	}
	public Bussies getBussies() {
		return bussies;
	}
	public void setBussies(Bussies bussies) {
		this.bussies = bussies;
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++){
			bussies.sub();
		}
		
	}
	
}