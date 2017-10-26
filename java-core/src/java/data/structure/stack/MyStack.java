package java.data.structure.stack;


public class MyStack {

	//底层实现是数组
	private long[] arr;
	private int top;
	
	/**
	 * 默认的构造方法
	 */
	public MyStack(){
		arr=new long[10];
		top=-1;
	}
	
	/**
	 * 不带参数的构造方法
	 * @param maxSize
	 */
	public MyStack(int maxSize){
		arr=new long[maxSize];
		top=-1;
	}
	
	/**
	 * 添加数据
	 * @param value
	 */
	public void push(int value){
		arr[++top]=value;
	}
	
	/**
	 * 弹出元素
	 * @return
	 */
	public long pop(){
		return arr[top--];
	}
	
	/**
	 * 查看元素
	 * @return
	 */
	public long peek(){
		return arr[top];
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return top==-1;
	}
	
	/**
	 * 判断是否满了
	 * @return
	 */
	public boolean isFull(){
		return top==arr.length-1;
	}
}
