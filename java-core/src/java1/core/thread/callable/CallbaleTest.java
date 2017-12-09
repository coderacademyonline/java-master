package java1.core.thread.callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * callable的用法
 * @author zhaojw_420
 *
 */
public class CallbaleTest {

	public static void main(String[] args) {
		ArrayList<Future<String>> futures=new ArrayList<Future<String>>();
		ExecutorService service=Executors.newCachedThreadPool(); 
		//还可以使用FutureTask，即  FutureTask<Integer> futureTask = new FutureTask<Integer>(new TaskCallable()); 
		//Thread thread = new Thread(futureTask);
        //thread.start();*
		//作用一样，但是用法不一样
		try{
		for (int i = 0; i < 10; i++) {
			Future<String> future=service.submit(new TaskCallable(i)); 
			futures.add(future);
		}
		for (Future<String> future : futures) {
			System.out.println(future.get());
		}
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			service.shutdown();
		}
	}
}

class TaskCallable  implements Callable<String>{

	private int i;
	
	public TaskCallable(int i) {
		this.i = i;
	}

	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "第"+(i+1	)+"次执行";
	}
	
}
