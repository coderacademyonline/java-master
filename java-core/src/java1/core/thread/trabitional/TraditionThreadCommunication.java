package java1.core.thread.trabitional;

public class TraditionThreadCommunication {

	public static void main(String[] args) {
		new TraditionThreadCommunication().init();
	}
	public void init(){
		final Business business=new Business();
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 1; i < 51; i++) {
					business.sub(i);
				}
			}
		}).start();
		for (int j = 1; j < 51; j++) {
			business.main(j);
		}
	}
	class Business{
		public boolean isAction=true;
		public synchronized void sub(int i){
			while(!isAction){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int a = 1; a < 11; a++) {
					System.err.println("子线程运行第"+a+",总共运行第"+i+"次");
				}
			}
			
			isAction=false;
			this.notify();
		}
		
		public synchronized void main(int j){
			while(isAction){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int a = 1; a < 101; a++) {
					System.err.println("主线程运行第"+a+",总共运行第"+j+"次");
				}
			}
			
			isAction=true;
			this.notify();
		}
	}
}
