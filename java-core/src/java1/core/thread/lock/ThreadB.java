package java1.core.thread.lock;

/**
 * <p></p>
 *
 * @author jwzhao
 * @version 1.0
 * @date 2019/3/26 15:20
 */
public class ThreadB extends Thread{

    private ThreadService threadService;

    public ThreadB(ThreadService threadService){
        super();
        this.threadService = threadService;
    }

    @Override
    public void run() {
        threadService.methodB();
    }
}
