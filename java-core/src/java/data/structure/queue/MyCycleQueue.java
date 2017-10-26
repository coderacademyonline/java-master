package java.data.structure.queue;

/**
 * 循环队列，底层数组实现，先进先出
 * @author Administrator
 *
 */
public class MyCycleQueue {

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
	public MyCycleQueue(){
		arr=new long[10];
		element=0;
		front=0;
		end=-1;
	}
	/**
	 * 带参构造方法
	 * @param maxSize
	 */
	public MyCycleQueue(int maxSize){
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
		if(end==arr.length-1){ //若队尾达到了长度，则，让队尾指向初始表头
			end=-1;
		}
		arr[++end]=value;
		element++;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public long remove(){
		
		long value=arr[front++];
		if (front==arr.length-1) {
			front=0;  //若对头达到长度则指向初始的队尾
		}
		element--;
		return value;
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
