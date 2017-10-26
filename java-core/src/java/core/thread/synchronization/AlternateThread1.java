package java.core.thread.synchronization;

public class AlternateThread1 {

	public static void main(String[] args) {
        final OperationOnMainAndSub o = new OperationOnMainAndSub();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    o.sub();
                }
            }
        }).start();
        for(int i = 0; i < 100; i++) {
            o.main();
        }
    }
}
class OperationOnMainAndSub{
    private boolean flag = true;
    
    public synchronized void main() {
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 100; i++) {
            System.out.println("主线程：" + i);
        }
        this.flag = true;
        this.notify();
    }
    
    public synchronized void sub() {
        if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("==============子线程：" + i);
        }
        this.flag = false;
        this.notify();
    }
    
}