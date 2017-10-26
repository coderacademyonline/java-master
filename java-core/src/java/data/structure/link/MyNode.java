package java.data.structure.link;

/**
 * 链表节点，相当于火车的车厢
 * @author Administrator
 *
 */
public class MyNode {

	//数据域
	public  long data;
	
	//指针域
	public  MyNode next;
	
	/**
	 * 前指针域
	 */
	public MyNode previous;
	
    /**
     * 创建节点，数据域赋值
     * @param value
     */
	public MyNode(long value){
		this.data=value;
	}
	
	public void display(){
		System.err.print(data+" ");
	}
}
