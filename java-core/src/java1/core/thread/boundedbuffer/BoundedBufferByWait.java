package java1.core.thread.boundedbuffer;

import java.util.LinkedList;


/**
 * 生产者消费者问题
 * @author zhaojw_420
 *
 */
public class BoundedBufferByWait {
	
	public static void main(String[] args) {
		//仓库对象
		Storge storge=new Storge();
		
		//生产者对象
		Producer p1=new Producer(storge);
		p1.setNum(10);
		Producer p2=new Producer(storge);
		p2.setNum(10);
		Producer p3=new Producer(storge);
		p3.setNum(10);
		Producer p4=new Producer(storge);
		p4.setNum(10);
		Producer p5=new Producer(storge);
		p5.setNum(10);
		Producer p6=new Producer(storge);
		p6.setNum(10);
		Producer p7=new Producer(storge);
		p7.setNum(10);
		//构建生产者对象线程
		Thread producer1=new Thread(p1);
		Thread producer2=new Thread(p2);
		Thread producer3=new Thread(p3);
		Thread producer4=new Thread(p4);
		Thread producer5=new Thread(p5);
		Thread producer6=new Thread(p6);
		Thread producer7=new Thread(p7);
		
		//消费者对象
		Consumer c1=new Consumer(storge);
		c1.setNum(50);
		Consumer c2=new Consumer(storge);
		c1.setNum(30);
		Consumer c3=new Consumer(storge);
		c1.setNum(20);
		
		//构建消费者对象线程
		Thread consumer1=new Thread(c1);
		Thread consumer2=new Thread(c2);
		Thread consumer3=new Thread(c3);
		
		//启动消费者线程
		consumer1.start();
		consumer2.start();
		consumer3.start();
		
		//启动生产者线程
		producer1.start();
		producer2.start();
		producer3.start();
		producer4.start();
		producer5.start();
		producer6.start();
		producer7.start();
	}
}
/**
 * 仓库类实现缓冲区
 * @author zhaojw_420
 *
 */
class Storge{

	/**
	 * 仓库最大存储量
	 */
	private final int MAX_SIZE=100;
	/**
	 * 仓库存储的载体
	 */
	private LinkedList<Object> list=new LinkedList<Object>();
	
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
		//同步代码快
		synchronized(list){
		while((list.size()+num)>MAX_SIZE){
			System.err.println(System.currentTimeMillis()+"，本次生产的产品数量："+num+"个，此时的库存量："+list.size()+"，暂时不能执行生产任务！");
			
			try {
				list.wait();//仓库已满，不能生产，此时生产线程处于阻塞状态
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
		
		list.notifyAll();//唤醒等待队列的线程
		}
	}
	/**
	 * 消费num个产品
	 * @param num
	 */
	public void consume(int num){
		//同步代码块
		synchronized(list){
			//仓库数量不足，无法消费
			while(list.size()<num){
				System.err.println(System.currentTimeMillis()+"，本次消费的产品数量为："+num+"，库存量："+list.size()+"，暂时不能执行生产任务！");
			    try {
					list.wait();//消费条件不满足，消费线程处于阻塞状态
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
			
			list.notifyAll();//唤醒等待队列的线程
		}
	}
}

/**
 * 生产类，实现Runable接口
 * @author zhaojw_420
 *
 */
class Producer implements Runnable{

	/**
	 * 每次成产产品数量
	 */
	private int num;
	
	/**
	 * 所放置的仓库
	 */
	private Storge storge;
	/**
	 * 构造方法，设置仓库
	 * @param boundedBuffer
	 */
	public Producer(Storge storge) {
		this.storge = storge;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		storge.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storge getStorge() {
		return storge;
	}

	public void setStorge(Storge storge) {
		this.storge = storge;
	}
}

/**
 * 消费者类，实现Runable接口
 * @author zhaojw_420
 *
 */
class Consumer implements Runnable{

	/**
	 * 每次消费的产品数量
	 */
	private int num;
	/**
	 * 存储仓库
	 */
	private Storge storge;
	/**
	 * 构造函数，设置仓库
	 * @param boundedBuffer
	 */
	public Consumer(Storge storge) {
		this.storge = storge;
	}

	@Override
	public void run() {
		storge.consume(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storge getStorge() {
		return storge;
	}

	public void setStorge(Storge storge) {
		this.storge = storge;
	}
}
