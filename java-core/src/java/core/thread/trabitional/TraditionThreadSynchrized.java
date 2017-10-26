package java.core.thread.trabitional;


public class TraditionThreadSynchrized {

	public static void main(String[] args) {
		new TraditionThreadSynchrized().init();
	}
    /**
     *此方法作用：内部类不能访问外部成员变量，除非成员变量设置为final。静态方法中不能new内部类的实例对象
     */
	public void init(){
		final Outputer outputer=new Outputer();
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.outputer("zhaojianwei");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.outputer2("zhangxiaoxiang");
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Outputer.outputer3("zhangxiaoxiang");
				}
			}
		}).start();
	}
	static class Outputer{
		//方法1：
		public void outputer(String name){
			//将线程都需要使用的代码用synchronized保护起来
			//this可用Outputer.class
			synchronized (this) {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		
		//方法2：
		public synchronized  void outputer2(String name){
			//将线程都需要使用的代码用synchronized保护起来
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				System.out.println();
			}
		}
		
		public static synchronized  void outputer3(String name){
			//将线程都需要使用的代码用synchronized保护起来
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i));
				System.out.println();
			}
		}
	}
}
