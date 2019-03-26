package java1.core.thread.lock;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/26 15:27
 */
public class ThreadRun {

    public static void main(String[] args) throws InterruptedException{
        ThreadService threadService = new ThreadService();
        ThreadA threadA = new ThreadA(threadService);
        threadA.setName("methodA");
        threadA.start();
        ThreadAA threadAA = new ThreadAA(threadService);
        threadAA.setName("methodAA");
        threadAA.start();
        Thread.sleep(2000);
        ThreadB threadB = new ThreadB(threadService);
        threadB.setName("threadB");
        threadB.start();
        ThreadBB threadBB = new ThreadBB(threadService);
        threadBB.setName("threadBB");
        threadBB.start();
    }
}
