package java1.core.thread.trabitional;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TrabitionalTimer {

	public static void main(String[] args) {
		
		new Timer().schedule(new MyTimerTask(), 2000);
		
		while(true){
			System.err.println("时间：   "+new Date().getSeconds());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyTimerTask extends TimerTask{

	static int count=0;
	@Override
	public void run() {
		count=(count+1)%2;
		// TODO Auto-generated method stub
		System.err.println("定时炸弹。。。。");//
		new Timer().schedule(new MyTimerTask(), 2000+2000*count);
	}
	
}