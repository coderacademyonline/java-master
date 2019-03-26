package java1.core.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/26 15:16
 */
public class ThreadService {

    private Lock lock = new ReentrantLock();

    public void methodA(){
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName="+Thread.currentThread().getName()+" time= "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA begin ThreadName="+Thread.currentThread().getName()+" time= "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName="+Thread.currentThread().getName()+" time= "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB begin ThreadName="+Thread.currentThread().getName()+" time= "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
