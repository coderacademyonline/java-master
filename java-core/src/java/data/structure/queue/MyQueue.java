package java.data.structure.queue;

/**
 * 队列，底层数组实现，先进先出
 * @author Administrator
 *
 */
public class MyQueue {

	/**
	 * 底层实现，数组
	 */
	private long[] arr;
	
	/**
	 * 有效元素的大小
	 */
	private int element;
	
	/**
	 * 队头
	 */
	private int front;
	
	/**
	 * 队尾
	 */
	private int end;
	
	/**
	 * 默认的构造方法
	 */
	public MyQueue(){
		arr=new long[10];
		element=0;
		front=0;
		end=-1;
	}
	/**
	 * 带参构造方法
	 * @param maxSize
	 */
	public MyQueue(int maxSize){
		arr=new long[maxSize];
		element=0;
		front=0;
		end=-1;
	}
	
	/**
	 * 添加数据
	 * @param value
	 */
	public void insert(int value){
		element++;
		arr[++end]=value;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public long remove(){
		element--;
		return arr[front++];
	}
	
	/**
	 * 查看元素
	 * @return
	 */
	public long peek(){
		return arr[front];
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return element==0;
	}
	
	/**
	 * 是否满了
	 * @return
	 */
	public boolean isFull(){
		return element==arr.length;
	}
}
