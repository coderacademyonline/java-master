package java1.core.thread.synchronization;

public class AlternatePrint {

	public static void main(String[] args) {
		final Info info=new Info();
		ThreadA threadA=new ThreadA(info);
		Thread t1=new Thread(threadA,"threadA");
		
		ThreadB threadB=new ThreadB(info);
		Thread t2=new Thread(threadB,"threadB");
		t1.start();
		t2.start();
	}
}

class Info{
	String infoA="i am zhaojw ,i am Irritability";
	String infoB="我是zhaojw，我很烦躁";
	boolean flage=false;//定义一个标志，决定哪个线程运行,false读A，true读B
	
	public void outA(){
		synchronized(this){
			while (flage) {//如果flage=false，才读取，若为true，wait()
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+" 正在读取："+infoA);
			flage=true;
			this.notifyAll();
		}
		
	}
	
	public void outB(){
		synchronized(this){
			while (!flage) {//如果flage=true，才读取，若为false，wait()
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(Thread.currentThread().getName()+" 正在读取："+infoB);
			flage=false;
			this.notifyAll();
		}
		
	}
}

class ThreadA implements Runnable{

	private Info info;
	
	public ThreadA(Info info) {
		this.info = info;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			info.outA();
		}
	}
}

class ThreadB implements Runnable{
    
	private Info info;
	
	public ThreadB(Info info) {
		this.info = info;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			info.outB();
		}
	}
}