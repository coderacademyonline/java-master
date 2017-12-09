package java1.core.thread.trabitional;

public class TraditionThread {

	public static void main(String[] args) {
		Thread thread1=new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("2:"+Thread.currentThread().getName());
				}
			}
		};
		//thread1.start();
		
		Thread thread2=new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("1:"+Thread.currentThread().getName());
				}
			}
		});
		//thread2.start();
		
		//形如new Thread(new Runable()){}.start();启动的是new Thread的线程
	    new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("runable:"+Thread.currentThread().getName());
				}
			}
		}){
	    	@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("thread:"+Thread.currentThread().getName());
				}
			}
	    }.start();
	}
}
