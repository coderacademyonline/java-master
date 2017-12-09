package java1.core.thread.boundedbuffer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 生产者消费者问题
 * @author zhaojw_420
 *
 */
public class BoundedBufferByAWait {
	
	public static void main(String[] args) {
		//仓库对象
		StorgeAwait storgeAwait=new StorgeAwait();
		
		//生产者对象
		ProducerAwait p1=new ProducerAwait(storgeAwait);
		p1.setNum(10);
		ProducerAwait p2=new ProducerAwait(storgeAwait);
		p2.setNum(10);
		ProducerAwait p3=new ProducerAwait(storgeAwait);
		p3.setNum(10);
		ProducerAwait p4=new ProducerAwait(storgeAwait);
		p4.setNum(10);
		ProducerAwait p5=new ProducerAwait(storgeAwait);
		p5.setNum(10);
		ProducerAwait p6=new ProducerAwait(storgeAwait);
		p6.setNum(10);
		ProducerAwait p7=new ProducerAwait(storgeAwait);
		p7.setNum(10);
		//构建生产者对象线程
		Thread producerAwait1=new Thread(p1);
		Thread producerAwait2=new Thread(p2);
		Thread producerAwait3=new Thread(p3);
		Thread producerAwait4=new Thread(p4);
		Thread producerAwait5=new Thread(p5);
		Thread producerAwait6=new Thread(p6);
		Thread producerAwait7=new Thread(p7);
		
		//消费者对象
		ConsumerAwait c1=new ConsumerAwait(storgeAwait);
		c1.setNum(50);
		ConsumerAwait c2=new ConsumerAwait(storgeAwait);
		c2.setNum(30);
		ConsumerAwait c3=new ConsumerAwait(storgeAwait);
		c3.setNum(20);
		
		//构建消费者对象线程
		Thread consumerAwait1=new Thread(c1);
		Thread consumerAwait2=new Thread(c2);
		Thread consumerAwait3=new Thread(c3);
		
		//启动消费者线程
		consumerAwait1.start();
		consumerAwait2.start();
		consumerAwait3.start();
		
		//启动生产者线程
		producerAwait1.start();
		producerAwait2.start();
		producerAwait3.start();
		producerAwait4.start();
		producerAwait5.start();
		producerAwait6.start();
		producerAwait7.start();
	}
}
/**
 * 仓库类实现缓冲区
 * @author zhaojw_420
 *
 */
class StorgeAwait{

	/**
	 * 仓库最大存储量
	 */
	private final int MAX_SIZE=100;
	/**
	 * 仓库存储的载体
	 */
	private LinkedList<Object> list=new LinkedList<Object>();
	
	/**
	 * 可重入锁
	 */
	private final Lock lock=new ReentrantLock();
	
	/**
	 * 仓库满条件
	 */
	private final Condition full=lock.newCondition();
	
	/**
	 * 仓库空条件
	 */
	private final Condition empty=lock.newCondition();
	
	public LinkedList<Object> getList() {
		return list;
	}
	public void setList(LinkedList<Object> list) {
		this.list = list;
	}
	public int getMAX_SIZE() {
		return MAX_SIZE;
	}
	/**
	 * 仓库中存进num个产品
	 * @param num 存储产品个数
	 */
	public void produce(int num){
		//获得锁
		lock.lock();
		
		while((list.size()+num)>MAX_SIZE){
			System.err.println(System.currentTimeMillis()+"，本次生产的产品数量："+num+"个，此时的库存量："+list.size()+"，暂时不能执行生产任务！");
			
			try {
				full.await();//仓库已满，不能生产，此时生产线程处于阻塞状态
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//仓库未满，可以生产，生产num个产品
		for (int i = 0; i < num; i++) {
			list.add(i);
		}
		
		System.out.println(System.currentTimeMillis()+"，此次生产产品数量："+num+"个，现在库存量为："+list.size());
		
		full.signalAll();//唤醒等待队列的线程
		empty.signalAll();
		
		//释放锁
		lock.unlock();
		
	}
	/**
	 * 消费num个产品
	 * @param num
	 */
	public void consume(int num){
		
		   //获得锁
		   lock.lock();
		
			//仓库数量不足，无法消费
			while(list.size()<num){
				System.err.println(System.currentTimeMillis()+"，本次消费的产品数量为："+num+"，库存量："+list.size()+"，暂时不能执行生产任务！");
			    try {
					empty.await();//消费条件不满足，消费线程处于阻塞状态
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			//消费情况满足，消费num个产品
			for (int i = 0; i < num; i++) {
				list.remove();
			}
			
			System.out.println(System.currentTimeMillis()+"，本次消费产品数量："+num+"，现库存量为："+list.size());
			
			empty.signalAll();	//唤醒等待队列的线程
			full.signalAll();
			
			lock.unlock();//释放锁
				
	}
}

/**
 * 生产类，实现Runable接口
 * @author zhaojw_420
 *
 */
class ProducerAwait implements Runnable{

	/**
	 * 每次成产产品数量
	 */
	private int num;
	
	/**
	 * 所放置的仓库
	 */
	private StorgeAwait storgeAwait;
	/**
	 * 构造方法，设置仓库
	 * @param boundedBuffer
	 */
	public ProducerAwait(StorgeAwait storgeAwait) {
		this.storgeAwait = storgeAwait;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		storgeAwait.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public StorgeAwait getStorgeAwait() {
		return storgeAwait;
	}

	public void setStorgeAwait(StorgeAwait storgeAwait) {
		this.storgeAwait = storgeAwait;
	}
}

/**
 * 消费者类，实现Runable接口
 * @author zhaojw_420
 *
 */
class ConsumerAwait implements Runnable{

	/**
	 * 每次消费的产品数量
	 */
	private int num;
	/**
	 * 存储仓库
	 */
	private StorgeAwait storgeAwait;
	/**
	 * 构造函数，设置仓库
	 * @param boundedBuffer
	 */
	public ConsumerAwait(StorgeAwait storgeAwait) {
		this.storgeAwait = storgeAwait;
	}

	@Override
	public void run() {
		storgeAwait.consume(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public StorgeAwait getStorgeAwait() {
		return storgeAwait;
	}

	public void setStorgeAwait(StorgeAwait storgeAwait) {
		this.storgeAwait = storgeAwait;
	}
}
